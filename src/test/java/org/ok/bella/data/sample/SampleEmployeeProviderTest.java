package org.ok.bella.data.sample;

import org.junit.jupiter.api.Test;
import org.ok.bella.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SampleEmployeeProviderTest {

    @Autowired
    private SampleEmployeeProvider sampleEmployeeProvider;

    @Test
    void shouldReturnItem() {
        Employee item = sampleEmployeeProvider.getItem();
        assertNotNull(item);
    }

    @Test
    void shouldReturnItems() {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        assertEquals(numberOfItems, items.size());
    }
}