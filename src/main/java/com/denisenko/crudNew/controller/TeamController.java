package com.denisenko.crudNew.controller;

import com.denisenko.crudNew.model.Team;
import com.denisenko.crudNew.repository.TeamRepository;
import com.denisenko.crudNew.repository.jdbc.JdbcTeamRepositoryImpl;

import java.util.List;

public class TeamController {
    private TeamRepository teamRepository;

    public TeamController() {
        teamRepository = new JdbcTeamRepositoryImpl();
    }

    public Team getByIdTeam(Long id) {
        return teamRepository.getById(id);
    }

    public List<Team> getAllTeams() {
        return teamRepository.getAll();
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeamById(Long idTeam) {
        teamRepository.deleteById(idTeam);
    }

    public Team updateTeam(Team team) {
        return teamRepository.update(team);
    }

}
