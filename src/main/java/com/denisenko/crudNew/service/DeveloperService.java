package com.denisenko.crudNew.service;

import com.denisenko.crudNew.model.Developer;
import com.denisenko.crudNew.repository.DeveloperRepository;
import com.denisenko.crudNew.repository.hibernate.HibernateDeveloperRepository;

import java.util.List;

public class DeveloperService {

    private DeveloperRepository developerRepository = new HibernateDeveloperRepository();

    public DeveloperRepository getDeveloperRepository() {
        return developerRepository;
    }

    public void setDeveloperRepository(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public Developer save(Developer developer) {
        return developerRepository.save(developer);
    }

    public Developer getById(Long id) {
        return developerRepository.getById(id);
    }

    public boolean delete(Long id) {
        return developerRepository.deleteById(id);
    }

    public List<Developer> getAll() {
        return developerRepository.getAll();
    }

    public Developer update(Developer developer) {
        return developerRepository.update(developer);
    }
}
