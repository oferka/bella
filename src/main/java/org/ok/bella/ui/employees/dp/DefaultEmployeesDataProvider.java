package org.ok.bella.ui.employees.dp;

import lombok.extern.slf4j.Slf4j;
import org.ok.bella.data.service.EmployeeService;
import org.ok.bella.model.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Employee> getItems() {
        return employeeService.findAll();
    }
}
