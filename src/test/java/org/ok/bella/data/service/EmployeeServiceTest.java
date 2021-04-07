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
        Iterable<Employee> foundItems = employeeService.findAll();
        assertNotNull(foundItems);
        employeeElasticsearchRepository.deleteAll(savedItems);
    }

    @Test
    public void shouldFindById() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        String id = items.get(0).getId();
        Optional<Employee> found = employeeElasticsearchRepository.findById(id);
        assertTrue(found.isPresent());
        assertEquals(id, found.get().getId());
        employeeElasticsearchRepository.deleteAll(savedItems);
    }

    @Test
    void shouldCount() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        long count = employeeService.count();
        assertEquals(count, numberOfItems);
        employeeElasticsearchRepository.deleteAll(savedItems);
    }
}