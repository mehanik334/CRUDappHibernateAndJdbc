package com.denisenko.crudNew.controller;

import com.denisenko.crudNew.model.Skill;
import com.denisenko.crudNew.service.SkillService;

import java.util.List;

public class SkillController {

    private SkillService skillService;

    public SkillController() {
        skillService = new SkillService();
    }

    public Skill getByIdSkill(Long id) {
        return skillService.getById(id);
    }

    public List<Skill> getAllSkills() {
        return skillService.getAll();
    }

    public Skill saveSkill(Skill skill) {
        return skillService.save(skill);
    }

    public boolean deleteSkillById(Long idSkill) {
        return skillService.delete(idSkill);
    }

    public Skill updateSkill(Skill skill) {
        return skillService.update(skill);
    }
}
