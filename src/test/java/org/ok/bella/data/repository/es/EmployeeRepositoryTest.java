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
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SampleEmployeeProvider sampleEmployeeProvider;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldSaveItem() {
        Employee item = sampleEmployeeProvider.getItem();
        Employee savedItem = employeeRepository.save(item);
        assertEquals(item, savedItem);
        employeeRepository.delete(savedItem);
    }

    @Test
    void shouldSaveItems() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeRepository.saveAll(items);
        assertNotNull(savedItems);
        employeeRepository.deleteAll(savedItems);
    }

    @Test
    void shouldFindItemById() {
        Employee item = sampleEmployeeProvider.getItem();
        Employee savedItem = employeeRepository.save(item);
        Optional<Employee> foundItemOptional = employeeRepository.findById(item.getId());
        assertTrue(foundItemOptional.isPresent());
        Employee foundItem = foundItemOptional.get();
        assertEquals(item, foundItem);
        employeeRepository.delete(savedItem);
    }

    @Test
    void shouldFindAllItems() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeRepository.saveAll(items);
        Iterable<Employee> foundItems = employeeRepository.findAll();
        assertNotNull(foundItems);
        employeeRepository.deleteAll(savedItems);
    }

    @Test
    void shouldFindAllItemsSortedByName() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeRepository.saveAll(items);
        Iterable<Employee> foundItems = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        assertNotNull(foundItems);
        employeeRepository.deleteAll(savedItems);
    }

    @Test
    void shouldFindAllItemsSortedById() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeRepository.saveAll(items);
        Iterable<Employee> foundItems = employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        assertNotNull(foundItems);
        employeeRepository.deleteAll(savedItems);
    }

    @Test
    void shouldFindAllItemsPaged() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeRepository.saveAll(items);
        Page<Employee> foundItems = employeeRepository.findAll(PageRequest.of(0, 4));
        assertNotNull(foundItems);
        employeeRepository.deleteAll(savedItems);
    }

    @Test
    void shouldFindAllItemsPagedAndSorted() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeRepository.saveAll(items);
        Page<Employee> foundItems = employeeRepository.findAll(PageRequest.of(0, 4, Sort.by(Sort.Direction.ASC, "name")));
        assertNotNull(foundItems);
        employeeRepository.deleteAll(savedItems);
    }

    @Test
    void shouldExistById() {
        Employee item = sampleEmployeeProvider.getItem();
        Employee savedItem = employeeRepository.save(item);
        boolean exists = employeeRepository.existsById(savedItem.getId());
        assertTrue(exists);
        employeeRepository.delete(savedItem);
    }

    @Test
    void shouldCount() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeRepository.saveAll(items);
        long count = employeeRepository.count();
        assertEquals(count, numberOfItems);
        employeeRepository.deleteAll(savedItems);
    }

    @Test
    void shouldDeleteItem() {
        Employee item = sampleEmployeeProvider.getItem();
        Employee savedItem = employeeRepository.save(item);
        employeeRepository.delete(item);
        boolean exists = employeeRepository.existsById(savedItem.getId());
        assertFalse(exists);
    }

    @Test
    void shouldDeleteById() {
        Employee item = sampleEmployeeProvider.getItem();
        Employee savedItem = employeeRepository.save(item);
        employeeRepository.deleteById(item.getId());
        boolean exists = employeeRepository.existsById(savedItem.getId());
        assertFalse(exists);
    }

    @Test
    void shouldDeleteItems() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeRepository.saveAll(items);
        int numberOfItemsToDelete = 3;
        employeeRepository.deleteAll(items.subList(0, numberOfItemsToDelete));
        long count = employeeRepository.count();
        assertEquals((numberOfItems-numberOfItemsToDelete), count);
        employeeRepository.deleteAll(savedItems);
    }

    @Test
    void shouldDeleteAllItems() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeRepository.saveAll(items);
        assertNotNull(savedItems);
        employeeRepository.deleteAll();
        long count = employeeRepository.count();
        assertEquals(0, count);
    }
}