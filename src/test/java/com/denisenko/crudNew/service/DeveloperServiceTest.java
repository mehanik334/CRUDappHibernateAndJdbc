package com.denisenko.crudNew.service;

import com.denisenko.crudNew.model.Developer;
import com.denisenko.crudNew.repository.DeveloperRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class DeveloperServiceTest {

    @Mock
    DeveloperRepository developerRepository;

    @InjectMocks
    DeveloperService developerService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        developerService.setDeveloperRepository(developerRepository);
    }

    @Test
    public void getByIdTest() {
        Mockito.when(developerRepository.getById(1L)).thenReturn(new Developer(1l, "Sasha","Denisenko"));
        String firstNameDeveloper = developerService.getById(1L).getFirstName();
        Assert.assertEquals("Sasha",firstNameDeveloper);
    }

    @Test
    public void saveTest() {
        Developer saveDeveloper = new Developer(3L, "Dmitro","Denisenko");
        Mockito.when(developerRepository.save(saveDeveloper)).thenReturn(saveDeveloper);
        Assert.assertEquals(saveDeveloper, developerService.save(saveDeveloper));
    }

    @Test
    public void deleteDeveloperTest() {
        Mockito.when(developerRepository.deleteById(1L)).thenReturn(true);
        Assert.assertTrue(developerService.delete(1L));
    }

    @Test
    public void getAllDevelopersTest() {
        List<Developer> developerList = new ArrayList<>();
        developerList.add(new Developer(1L, "Ivan", "Ivanov"));
        developerList.add(new Developer(2L, "Semen" , "Semenov"));
        developerList.add(new Developer(3L, "Petr", "Petrov"));

        Mockito.when(developerRepository.getAll()).thenReturn(developerList);
        List<Developer> developerList1 = developerService.getAll();
        Assert.assertEquals(3, developerList1.size());

        Mockito.verify(developerRepository, Mockito.times(1)).getAll();
    }

    @Test
    public void updateDeveloperTest() {
        Developer developerBeforeUpdate = new Developer(1L, "Ivan", "Ivanov");
        Mockito.when(developerRepository.getById(1L)).thenReturn(developerBeforeUpdate);

        Developer updateDeveloper = new Developer(1L, "Semen" , "Semenov");
        Mockito.when(developerRepository.update(updateDeveloper)).thenReturn(updateDeveloper);

        Assert.assertNotEquals(developerService.update(updateDeveloper).getFirstName(), developerBeforeUpdate.getFirstName());
    }
}
