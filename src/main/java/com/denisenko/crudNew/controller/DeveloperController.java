package com.denisenko.crudNew.controller;

import com.denisenko.crudNew.model.Developer;
import com.denisenko.crudNew.repository.DeveloperRepository;
import com.denisenko.crudNew.repository.jdbc.JdbcDeveloperRepositoryImpl;

import java.util.List;

public class DeveloperController {

    private DeveloperRepository developerRepository;

    public DeveloperController() {
        developerRepository = new JdbcDeveloperRepositoryImpl();
    }

    public Developer getByIdDeveloper(Long id) {
        return developerRepository.getById(id);
    }

    public List<Developer> getAllDevelopers() {
        return developerRepository.getAll();
    }

    public Developer saveDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    public boolean deleteDeveloperById(Long idDeveloper) {
        return developerRepository.deleteById(idDeveloper);
    }

    public Developer updateDeveloper(Developer developer) {
        return developerRepository.update(developer);
    }
}
