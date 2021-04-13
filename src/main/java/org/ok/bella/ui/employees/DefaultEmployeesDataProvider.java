package org.ok.bella.ui.employees;

import lombok.extern.slf4j.Slf4j;
import org.ok.bella.data.service.EmployeeService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@Slf4j
public class DefaultEmployeesDataProvider implements EmployeesDataProvider {

    private final EmployeeService employeeService;

    public DefaultEmployeesDataProvider(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public long count() {
        return employeeService.count();
    }
}
