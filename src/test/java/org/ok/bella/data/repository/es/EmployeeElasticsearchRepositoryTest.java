package org.ok.bella.data.repository.es;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ok.bella.data.sample.SampleEmployeeProvider;
import org.ok.bella.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeElasticsearchRepositoryTest {

    @Autowired
    private EmployeeElasticsearchRepository employeeElasticsearchRepository;

    @Autowired
    private SampleEmployeeProvider sampleEmployeeProvider;

    @Test
    void shouldSaveItem() {
        Employee item = sampleEmployeeProvider.getItem();
        Employee savedItem = employeeElasticsearchRepository.save(item);
        assertEquals(item, savedItem);
        employeeElasticsearchRepository.delete(savedItem);
    }

    @Test
    void shouldSaveItems() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        assertNotNull(savedItems);
        employeeElasticsearchRepository.deleteAll(savedItems);
    }

    @Test
    void shouldFindItemById() {
        Employee item = sampleEmployeeProvider.getItem();
        Employee savedItem = employeeElasticsearchRepository.save(item);
        Optional<Employee> foundItemOptional = employeeElasticsearchRepository.findById(item.getId());
        assertTrue(foundItemOptional.isPresent());
        Employee foundItem = foundItemOptional.get();
        assertEquals(item, foundItem);
        employeeElasticsearchRepository.delete(savedItem);
    }

    @Test
    void shouldFindAllItems() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        Iterable<Employee> foundItems = employeeElasticsearchRepository.findAll();
        assertNotNull(foundItems);
        employeeElasticsearchRepository.deleteAll(savedItems);
    }

    @Test
    void shouldFindAllItemsSortedByName() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        Iterable<Employee> foundItems = employeeElasticsearchRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        assertNotNull(foundItems);
        employeeElasticsearchRepository.deleteAll(savedItems);
    }

    @Test
    void shouldFindAllItemsSortedById() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        Iterable<Employee> foundItems = employeeElasticsearchRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        assertNotNull(foundItems);
        employeeElasticsearchRepository.deleteAll(savedItems);
    }

    @Test
    void shouldFindAllItemsPaged() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        Page<Employee> foundItems = employeeElasticsearchRepository.findAll(PageRequest.of(0, 4));
        assertNotNull(foundItems);
        employeeElasticsearchRepository.deleteAll(savedItems);
    }

    @Test
    void shouldFindAllItemsPagedAndSorted() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        Page<Employee> foundItems = employeeElasticsearchRepository.findAll(PageRequest.of(0, 4, Sort.by(Sort.Direction.ASC, "name")));
        assertNotNull(foundItems);
        employeeElasticsearchRepository.deleteAll(savedItems);
    }

    @Test
    void shouldExistById() {
        Employee item = sampleEmployeeProvider.getItem();
        Employee savedItem = employeeElasticsearchRepository.save(item);
        boolean exists = employeeElasticsearchRepository.existsById(savedItem.getId());
        assertTrue(exists);
        employeeElasticsearchRepository.delete(savedItem);
    }

    @Test
    void shouldCount() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        long count = employeeElasticsearchRepository.count();
        assertEquals(count, numberOfItems);
        employeeElasticsearchRepository.deleteAll(savedItems);
    }

    @Test
    void shouldDeleteItem() {
        Employee item = sampleEmployeeProvider.getItem();
        Employee savedItem = employeeElasticsearchRepository.save(item);
        employeeElasticsearchRepository.delete(item);
        boolean exists = employeeElasticsearchRepository.existsById(savedItem.getId());
        assertFalse(exists);
    }

    @Test
    void shouldDeleteById() {
        Employee item = sampleEmployeeProvider.getItem();
        Employee savedItem = employeeElasticsearchRepository.save(item);
        employeeElasticsearchRepository.deleteById(item.getId());
        boolean exists = employeeElasticsearchRepository.existsById(savedItem.getId());
        assertFalse(exists);
    }

    @Test
    void shouldDeleteItems() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        int numberOfItemsToDelete = 3;
        employeeElasticsearchRepository.deleteAll(items.subList(0, numberOfItemsToDelete));
        long count = employeeElasticsearchRepository.count();
        assertEquals((numberOfItems-numberOfItemsToDelete), count);
        employeeElasticsearchRepository.deleteAll(savedItems);
    }

    @Test
    void shouldDeleteAllItems() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        assertNotNull(savedItems);
        employeeElasticsearchRepository.deleteAll();
        long count = employeeElasticsearchRepository.count();
        assertEquals(0, count);
    }
}