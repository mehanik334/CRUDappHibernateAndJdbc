package com.denisenko.crudNew.repository.jdbc;

import com.denisenko.crudNew.model.Developer;
import com.denisenko.crudNew.model.Skill;
import com.denisenko.crudNew.model.Team;
import com.denisenko.crudNew.repository.DeveloperRepository;
import com.denisenko.crudNew.repository.SkillRepository;
import com.denisenko.crudNew.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDeveloperRepositoryImpl implements DeveloperRepository {

    private SkillRepository skillRepository = new JdbcSkillRepositoryImpl();

    @Override
    public Developer getById(Long aLong) {

        Developer resultDev = new Developer();
        List<Skill> skillList = new ArrayList<>();
        resultDev.setSkills(skillList);

        String sqlGetById = "select d.id,d.first_name,d.last_name,s.skill_id, s.name, d.team_id, t.team_name from developer d\n" +
                "                                join developer_skill ds on d.id = ds.developer_id\n" +
                "                                join skill s on ds.skill_id = s.skill_id\n" +
                "                                join team t on d.team_id = t.id\n" +
                "                                where d.id = ?;";

        try (PreparedStatement preparedStatement = JdbcUtils.getPrepareStatement(sqlGetById);) {

            preparedStatement.setLong(1,aLong);
            ResultSet resultSet = preparedStatement.executeQuery();
            mapDeveloperFromDB(resultDev, resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultDev;
    }

    @Override
    public Developer save(Developer developer) {
        String sqlSaveDeveloper = "INSERT INTO developer(id, first_name, last_name, team_id) VALUES (?,?,?,?);";
        String sqlSaveSkillDeveloper = "INSERT INTO developer_skill(developer_id) VALUES (?,?);";
        try (PreparedStatement preparedStatement = JdbcUtils.getPrepareStatement(sqlSaveDeveloper);
             PreparedStatement preparedStatement1 = JdbcUtils.getPrepareStatement(sqlSaveSkillDeveloper)) {
            preparedStatement.setLong(1, developer.getId());
            preparedStatement.setString(2, developer.getFirstName());
            preparedStatement.setString(3, developer.getLastName());
            preparedStatement.setLong(4, developer.getTeam().getId());
            preparedStatement.execute();

            for (int i = 0; i < developer.getSkills().size(); i++) {
                preparedStatement1.setLong(1, developer.getId());
                preparedStatement1.setLong(2, developer.getSkills().get(i).getId());
                preparedStatement1.execute();
                skillRepository.save(developer.getSkills().get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getById(developer.getId());
    }

    @Override
    public boolean deleteById(Long aLong) {
        Boolean deleteRes = false;
        String sqlDeleteFromDeveloper = "delete from developer where developer.id = ?";
        String sqlDeleteFromDeveloperSkill = "DELETE FROM developer_skill WHERE developer_id IN (SELECT id FROM developer WHERE id = ?);";

        deleteRes = deleteDeveloperFromDB(sqlDeleteFromDeveloper, aLong);
        deleteRes = deleteDeveloperFromDB(sqlDeleteFromDeveloperSkill, aLong);

        return !deleteRes;
    }

    @Override
    public List<Developer> getAll() {
        List<Developer> allDevelopers = new ArrayList<>();
        String sqlGetAll = "select * from developer;";
        try (PreparedStatement preparedStatement = JdbcUtils.getPrepareStatement(sqlGetAll)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Developer developer = new Developer();
                developer.setId(resultSet.getLong("id"));
                developer.setFirstName(resultSet.getString("first_name"));
                developer.setLastName(resultSet.getString("last_name"));
                allDevelopers.add(developer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allDevelopers;
    }

    @Override
    public Developer update(Developer developer) {
        String sqlUpdateDeveloper = "update developer set first_name = ?, last_name = ?, team_id = ? where id = ?;";
        try (PreparedStatement preparedStatement = JdbcUtils.getPrepareStatement(sqlUpdateDeveloper)) {

            preparedStatement.setString(1, developer.getFirstName());
            preparedStatement.setString(2, developer.getLastName());
            preparedStatement.setLong(3, developer.getTeam().getId());
            preparedStatement.setLong(4, developer.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getById(developer.getId());
    }

    private void mapDeveloperFromDB(Developer developer, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            developer.setId(resultSet.getLong("id"));
            developer.setFirstName(resultSet.getString("first_name"));
            developer.setLastName(resultSet.getString("last_name"));
            developer.getSkills().add(new Skill(resultSet.getLong("skill_id"),resultSet.getString("name") ));
            Team team = new Team(resultSet.getLong("team_id"), resultSet.getString("team_name"));
            developer.setTeam(team);
        }

    }

    private boolean deleteDeveloperFromDB(String sql, Long id) {
        boolean deleteDevRes = false;
        try (PreparedStatement preparedStatement = JdbcUtils.getPrepareStatement(sql)) {
            assert preparedStatement != null;
            preparedStatement.setLong(1, id);
            deleteDevRes = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleteDevRes;
    }
}
