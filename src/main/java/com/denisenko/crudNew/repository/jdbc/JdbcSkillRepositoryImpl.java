package com.denisenko.crudNew.repository.jdbc;

import com.denisenko.crudNew.model.Skill;
import com.denisenko.crudNew.repository.SkillRepository;
import com.denisenko.crudNew.utils.ConnectionPoolDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcSkillRepositoryImpl implements SkillRepository {
    @Override
    public Skill getById(Long aLong) {
        String sqlSkillById = "select name from skill where skill_id = ?;";
        Skill skillResultFromDB = new Skill();
        try (Connection connection = ConnectionPoolDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlSkillById)) {
            preparedStatement.setLong(1, aLong);
            ResultSet resultSet = preparedStatement.executeQuery();
            skillResultFromDB.setId(aLong);
            while (resultSet.next()) {
                skillResultFromDB.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skillResultFromDB;
    }

    @Override
    public Skill save(Skill skill) {
        String sqlInsertSkillToDb = "insert into skill values (?,?);";
        try (Connection connection = ConnectionPoolDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertSkillToDb)) {
            preparedStatement.setLong(1, skill.getId());
            preparedStatement.setString(2, skill.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getById(skill.getId());
    }

    @Override
    public boolean deleteById(Long aLong) {
        String sqlDeleteSkillFromDB = "delete s from skill s\n" +
                "join developer_skill ds on s.skill_id = ds.skill_id\n" +
                "where ds.skill_id = ?;";
        Boolean deleteBoolRes = false;
        try (Connection connection = ConnectionPoolDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteSkillFromDB)) {
            preparedStatement.setLong(1, aLong);
            deleteBoolRes = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return !deleteBoolRes;
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> skillList = new ArrayList<>();
        String sqlGetAllSkillFromDB = "select * from skill;";
        try (Connection connection = ConnectionPoolDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlGetAllSkillFromDB);
            while (resultSet.next()) {
                skillList.add(new Skill(resultSet.getLong("skill_id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skillList;
    }

    @Override
    public Skill update(Skill skill) {
        String sqlUpdateSkillInDb = "update skill set name = ? where skill_id = ?;";
        Skill updateSkill = null;
        try (Connection connection = ConnectionPoolDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateSkillInDb)) {
            preparedStatement.setString(1, skill.getName());
            preparedStatement.setLong(2, skill.getId());
            if (!preparedStatement.execute()) updateSkill = skill;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updateSkill;
    }
}
