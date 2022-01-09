package com.denisenko.crudNew.service;

import com.denisenko.crudNew.model.Team;
import com.denisenko.crudNew.repository.TeamRepository;
import com.denisenko.crudNew.repository.jdbc.JdbcTeamRepositoryImpl;

import java.util.List;

public class TeamService {

    private TeamRepository teamRepository = new JdbcTeamRepositoryImpl();

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public Team getById(Long id) {
        return teamRepository.getById(id);
    }

    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

    public List<Team> getAll() {
        return teamRepository.getAll();
    }

    public Team update(Team team) {
        return teamRepository.update(team);
    }
}
