package org.ok.bella.data.service;

import org.junit.jupiter.api.Test;
import org.ok.bella.data.repository.es.EmployeeElasticsearchRepository;
import org.ok.bella.data.sample.SampleEmployeeProvider;
import org.ok.bella.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeElasticsearchRepository employeeElasticsearchRepository;

    @Autowired
    private SampleEmployeeProvider sampleEmployeeProvider;

    @Test
    public void shouldFindAll() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        List<Employee> foundItems = employeeService.findAll();
        assertNotNull(foundItems);
        employeeElasticsearchRepository.deleteAll(savedItems);
    }

    @Test
    public void shouldFindById() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        String id = items.get(0).getId();
        Optional<Employee> found = employeeService.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
        employeeElasticsearchRepository.deleteAll(savedItems);
    }

    @Test
    public void shouldSave() {
        Employee item = sampleEmployeeProvider.getItem();
        Employee saved = employeeService.save(item);
        assertEquals(saved, item);
        employeeElasticsearchRepository.delete(item);
    }

    @Test
    public void shouldDeleteById() {
        Employee item = sampleEmployeeProvider.getItem();
        Employee saved = employeeElasticsearchRepository.save(item);
        String id = saved.getId();
        employeeService.deleteById(id);
        boolean exists = employeeElasticsearchRepository.existsById(id);
        assertFalse(exists);
    }

    @Test
    void shouldCount() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        long count = employeeService.count();
        employeeElasticsearchRepository.deleteAll(savedItems);
    }
}