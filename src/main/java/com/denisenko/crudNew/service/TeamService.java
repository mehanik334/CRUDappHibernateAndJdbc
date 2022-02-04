package com.denisenko.crudNew.service;

import com.denisenko.crudNew.model.Team;
import com.denisenko.crudNew.repository.TeamRepository;
import com.denisenko.crudNew.repository.hibernate.HibernateTeamRepository;
import com.denisenko.crudNew.repository.jdbc.JdbcTeamRepositoryImpl;

import java.util.List;

public class TeamService {

    private TeamRepository teamRepository = new HibernateTeamRepository();

    public TeamRepository getTeamRepository() {
        return teamRepository;
    }

    public void setTeamRepository(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public Team getById(Long id) {
        return teamRepository.getById(id);
    }

    public boolean delete(Long id) {
        return teamRepository.deleteById(id);
    }

    public List<Team> getAll() {
        return teamRepository.getAll();
    }

    public Team update(Team team) {
        return teamRepository.update(team);
    }
}
