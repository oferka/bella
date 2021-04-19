package org.ok.bella.ui.employees.dp;

import lombok.extern.slf4j.Slf4j;
import org.ok.bella.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;

@Service
@Slf4j
public class MockEmployeesDataProvider implements EmployeesDataProvider {

    @Override
    public long count() {
        return 30;
    }

    @Override
    public List<Employee> getItems() {
        return emptyList();
    }
}
