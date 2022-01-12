package com.denisenko.crudNew.controller;

import com.denisenko.crudNew.model.Skill;
import com.denisenko.crudNew.repository.SkillRepository;
import com.denisenko.crudNew.repository.jdbc.JdbcSkillRepositoryImpl;

import java.util.List;

public class SkillController {

    private SkillRepository skillRepository;

    public SkillController() {
        skillRepository = new JdbcSkillRepositoryImpl();
    }

    public Skill getByIdSkill(Long id) {
        return skillRepository.getById(id);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.getAll();
    }

    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public boolean deleteSkillById(Long idSkill) {
        return skillRepository.deleteById(idSkill);
    }

    public Skill updateSkill(Skill skill) {
        return skillRepository.update(skill);
    }
}
