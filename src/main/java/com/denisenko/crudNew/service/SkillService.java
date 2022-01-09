package com.denisenko.crudNew.service;

import com.denisenko.crudNew.model.Skill;
import com.denisenko.crudNew.repository.SkillRepository;
import com.denisenko.crudNew.repository.jdbc.JdbcSkillRepositoryImpl;

import java.util.List;

public class SkillService {

    private SkillRepository skillRepository = new JdbcSkillRepositoryImpl();

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill getById(Long id) {
        return skillRepository.getById(id);
    }

    public void delete(Long id) {
        skillRepository.deleteById(id);
    }

    public List<Skill> getAll() {
        return skillRepository.getAll();
    }

    public Skill update(Skill skill) {
        return skillRepository.update(skill);
    }
}
