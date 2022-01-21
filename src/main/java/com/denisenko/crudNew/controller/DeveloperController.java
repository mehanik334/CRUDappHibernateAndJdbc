package com.denisenko.crudNew.controller;

import com.denisenko.crudNew.model.Developer;
import com.denisenko.crudNew.service.DeveloperService;

import java.util.List;

public class DeveloperController {

    private DeveloperService developerService;

    public DeveloperController() {
        developerService = new DeveloperService();
    }

    public Developer getByIdDeveloper(Long id) {
        return developerService.getById(id);
    }

    public List<Developer> getAllDevelopers() {
        return developerService.getAll();
    }

    public Developer saveDeveloper(Developer developer) {
        return developerService.save(developer);
    }

    public boolean deleteDeveloperById(Long idDeveloper) {
        return developerService.delete(idDeveloper);
    }

    public Developer updateDeveloper(Developer developer) {
        return developerService.update(developer);
    }
}
