package com.denisenko.crudNew.service;

import com.denisenko.crudNew.model.Skill;
import com.denisenko.crudNew.repository.SkillRepository;
import com.denisenko.crudNew.repository.hibernate.HibernateSkillRepository;
import com.denisenko.crudNew.repository.jdbc.JdbcSkillRepositoryImpl;

import java.util.List;

public class SkillService {

    private SkillRepository skillRepository = new HibernateSkillRepository();

    public SkillRepository getSkillRepository() {
        return skillRepository;
    }

    public void setSkillRepository(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill getById(Long id) {
        return skillRepository.getById(id);
    }

    public boolean delete(Long id) {
        return skillRepository.deleteById(id);
    }

    public List<Skill> getAll() {
        return skillRepository.getAll();
    }

    public Skill update(Skill skill) {
        return skillRepository.update(skill);
    }
}
