package com.denisenko.crudNew.service;

import com.denisenko.crudNew.model.Team;
import com.denisenko.crudNew.repository.TeamRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class TeamServiceTest {

    @Mock
    TeamRepository teamRepository;

    @InjectMocks
    TeamService teamService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        teamService.setTeamRepository(teamRepository);
    }

    @Test
    public void getByIdTest() {
        Mockito.when(teamRepository.getById(1L)).thenReturn(new Team(1l, "Java team"));
        String nameTeam = teamService.getById(1L).getName();
        Assert.assertEquals("Java team", nameTeam);
    }

    @Test
    public void saveTest() {
        Team saveTeam = new Team(3L, "C++");
        Mockito.when(teamRepository.save(saveTeam)).thenReturn(saveTeam);
        Assert.assertEquals(saveTeam, teamService.save(saveTeam));
    }

    @Test
    public void deleteTeamTest() {
        Mockito.when(teamRepository.deleteById(1L)).thenReturn(true);
        Assert.assertTrue(teamService.delete(1L));
    }

        @Test
        public void getAllTeamsTest() {
            List<Team> teamList = new ArrayList<>();
            teamList.add(new Team(1L, "Java"));
            teamList.add(new Team(2L, "C++"));
            teamList.add(new Team(3L, "PHP"));

            Mockito.when(teamRepository.getAll()).thenReturn(teamList);
            List<Team> teamList1 = teamService.getAll();
            Assert.assertEquals(3, teamList1.size());

            Mockito.verify(teamRepository, Mockito.times(1)).getAll();
        }

    @Test
    public void updateTeamTest() {
        Team teamBeforeUpdate = new Team(1L, "Java");
        Mockito.when(teamRepository.getById(1L)).thenReturn(teamBeforeUpdate);

        Team updateTeam = new Team(1L, "Phyton");
        Mockito.when(teamRepository.update(updateTeam)).thenReturn(updateTeam);
        
        Assert.assertNotEquals(teamService.update(updateTeam).getName(), teamBeforeUpdate.getName());
    }

}
