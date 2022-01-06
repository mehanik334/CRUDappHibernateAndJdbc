package com.denisenko.crudNew;

import com.denisenko.crudNew.model.Developer;
import com.denisenko.crudNew.model.Skill;
import com.denisenko.crudNew.repository.DeveloperRepository;
import com.denisenko.crudNew.repository.SkillRepository;
import com.denisenko.crudNew.repository.TeamRepository;
import com.denisenko.crudNew.repository.jdbc.JdbcDeveloperRepositoryImpl;
import com.denisenko.crudNew.repository.jdbc.JdbcSkillRepositoryImpl;
import com.denisenko.crudNew.repository.jdbc.JdbcTeamRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class RunApp {
    public static void main(String[] args) {
        DeveloperRepository developerRepository = new JdbcDeveloperRepositoryImpl();
        SkillRepository skillRepository = new JdbcSkillRepositoryImpl();
        TeamRepository teamRepository = new JdbcTeamRepositoryImpl();
        System.out.println(teamRepository.getById(1L));
//       Developer d = developerRepository.getById(1L);
//        System.out.println(d);
//        Developer developer = new Developer(4L,"Dr","Fer");
//        List<Skill> skillList = new ArrayList<>();
//        skillList.add(new Skill(1L,"Java"));
//        developer.setSkills(skillList);
//        System.out.println(developerRepository.save(developer));
//        developerRepository.deleteById(4L);
//        System.out.println(developerRepository.getAll());
//        System.out.println(skillRepository.update(new Skill(3L,"Frame")));
//        System.out.println(skillRepository.getAll());
    }
}