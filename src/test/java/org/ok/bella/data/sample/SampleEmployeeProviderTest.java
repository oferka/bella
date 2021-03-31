package org.ok.bella.data.sample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.ok.bella.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SampleEmployeeProviderTest {

    @Autowired
    private SampleEmployeeProvider sampleEmployeeProvider;

    @Test
    void shouldReturnItem() {
        Employee employee = sampleEmployeeProvider.getItem();
        assertNotNull(employee);
    }
}