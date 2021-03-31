package org.ok.bella.data.repository.es;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.ok.bella.data.sample.SampleEmployeeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}