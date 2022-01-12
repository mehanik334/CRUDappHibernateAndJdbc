package com.denisenko.crudNew.repository.jdbc;

import com.denisenko.crudNew.model.Developer;
import com.denisenko.crudNew.model.Team;
import com.denisenko.crudNew.repository.DeveloperRepository;
import com.denisenko.crudNew.repository.TeamRepository;
import com.denisenko.crudNew.utils.ConnectionPoolDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTeamRepositoryImpl implements TeamRepository {

    private DeveloperRepository developerRepository = new JdbcDeveloperRepositoryImpl();

    @Override
    public Team getById(Long aLong) {
        String sqlTeamById = "Select team_name from team where id = ?";
        String sqlDeveloperTeamById = "Select id from developer where team_id = ?";
        Team teamResultFromDb = new Team();
        teamResultFromDb.setId(aLong);
        List<Developer> developerList = new ArrayList<>();
        try (Connection connection = ConnectionPoolDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlTeamById);
             PreparedStatement preparedStatement1 = connection.prepareStatement(sqlDeveloperTeamById)) {

            preparedStatement.setLong(1, aLong);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                teamResultFromDb.setName(resultSet.getString("team_name"));
            }

            preparedStatement1.setLong(1, aLong);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
                developerList.add(developerRepository.getById(resultSet1.getLong("id")));
            }
            teamResultFromDb.setDevelopers(developerList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teamResultFromDb;
    }

    @Override
    public Team save(Team team) {
        String sqlInsertTeamToDb = "insert into team values (?,?);";
        try (Connection connection = ConnectionPoolDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertTeamToDb)) {

            preparedStatement.setLong(1, team.getId());
            preparedStatement.setString(2, team.getName());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getById(team.getId());
    }

    @Override
    public boolean deleteById(Long aLong) {
        String sqlDeleteTeamFromDb = "DELETE t from team t where t.id = ?;";
        Boolean deleteBoolRes = false;
        try (Connection connection = ConnectionPoolDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteTeamFromDb)) {

            preparedStatement.setLong(1, aLong);
           deleteBoolRes = preparedStatement.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return !deleteBoolRes;
    }

    @Override
    public List<Team> getAll() {
        String sqlGetAllTeams = "SELECT * from team;";
        List<Team> teamList = new ArrayList<>();
        try (Connection connection = ConnectionPoolDB.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sqlGetAllTeams);
            while (resultSet.next()) {
                teamList.add(new Team(resultSet.getLong("id"), resultSet.getString("team_name")));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return teamList;
    }

    @Override
    public Team update(Team team) {
        String sqlUpdateTeam = "update team set name = ? where id = ?;";
        try (Connection connection = ConnectionPoolDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateTeam)) {

            preparedStatement.setString(1, team.getName());
            preparedStatement.setLong(2, team.getId());
            preparedStatement.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return getById(team.getId());
    }
}
