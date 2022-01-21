package com.denisenko.crudNew.controller;

import com.denisenko.crudNew.model.Team;
import com.denisenko.crudNew.service.TeamService;

import java.util.List;

public class TeamController {
    private TeamService teamService;

    public TeamController() {
        teamService = new TeamService();
    }

    public Team getByIdTeam(Long id) {
        return teamService.getById(id);
    }

    public List<Team> getAllTeams() {
        return teamService.getAll();
    }

    public Team saveTeam(Team team) {
        return teamService.save(team);
    }

    public boolean deleteTeamById(Long idTeam) {
        return teamService.delete(idTeam);
    }

    public Team updateTeam(Team team) {
        return teamService.update(team);
    }

}
