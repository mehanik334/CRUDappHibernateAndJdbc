package com.denisenko.crudNew.service;

import com.denisenko.crudNew.model.Skill;
import com.denisenko.crudNew.repository.SkillRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class SkillServiceTest {

    @Mock
    SkillRepository skillRepository;

    @InjectMocks
    SkillService skillService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        skillService.setSkillRepository(skillRepository);
    }

    @Test
    public void getByIdTest() {
        Mockito.when(skillRepository.getById(1L)).thenReturn(new Skill(1l, "Java"));
        String nameTeam = skillService.getById(1L).getName();
        Assert.assertEquals("Java", nameTeam);
    }

    @Test
    public void saveTest() {
        Skill saveSkill = new Skill(3L, "C++");
        Mockito.when(skillRepository.save(saveSkill)).thenReturn(saveSkill);
        Assert.assertEquals(saveSkill, skillService.save(saveSkill));
    }

    @Test
    public void deleteTeamTest() {
        Mockito.when(skillRepository.deleteById(1L)).thenReturn(true);
        Assert.assertTrue(skillService.delete(1L));
    }

    @Test
    public void getAllTeamsTest() {
        List<Skill> skillList = new ArrayList<>();
        skillList.add(new Skill(1L, "Java"));
        skillList.add(new Skill(2L, "C++"));
        skillList.add(new Skill(3L, "PHP"));

        Mockito.when(skillRepository.getAll()).thenReturn(skillList);
        List<Skill> skillList1 = skillService.getAll();
        Assert.assertEquals(3, skillList1.size());

        Mockito.verify(skillRepository, Mockito.times(1)).getAll();
    }

    @Test
    public void updateTeamTest() {
        Skill skillBeforeUpdate = new Skill(1L, "Java");
        Mockito.when(skillRepository.getById(1L)).thenReturn(skillBeforeUpdate);

        Skill updateSkill = new Skill(1L, "Phyton");
        Mockito.when(skillRepository.update(updateSkill)).thenReturn(updateSkill);

        Assert.assertNotEquals(skillService.update(updateSkill).getName(), skillBeforeUpdate.getName());
    }
}
