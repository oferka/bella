package org.ok.bella.data.sample;

import org.ok.bella.data.service.EmployeeService;
import org.ok.bella.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultSampleEmployeeService implements SampleEmployeeService {

    private final SampleEmployeeProvider sampleEmployeeProvider;

    private final EmployeeService employeeService;

    public DefaultSampleEmployeeService(SampleEmployeeProvider sampleEmployeeProvider, EmployeeService employeeService) {
        this.sampleEmployeeProvider = sampleEmployeeProvider;
        this.employeeService = employeeService;
    }

    @Override
    public Iterable<Employee> load() {
        List<Employee> employees = sampleEmployeeProvider.getItems(12);
        return employeeService.save(employees);
    }
}
