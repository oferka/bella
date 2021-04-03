package org.ok.bella.data.repository.es;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ok.bella.data.sample.SampleEmployeeProvider;
import org.ok.bella.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}