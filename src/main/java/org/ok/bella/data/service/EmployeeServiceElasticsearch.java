package org.ok.bella.data.service;

import org.ok.bella.data.repository.es.EmployeeElasticsearchRepository;
import org.ok.bella.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceElasticsearch implements EmployeeService {

    private final EmployeeElasticsearchRepository employeeElasticsearchRepository;

    public EmployeeServiceElasticsearch(EmployeeElasticsearchRepository employeeElasticsearchRepository) {
        this.employeeElasticsearchRepository = employeeElasticsearchRepository;
    }

    @Override
    public Iterable<Employee> findAll() {
        return employeeElasticsearchRepository.findAll();
    }

    @Override
    public long count() {
        return employeeElasticsearchRepository.count();
    }
}
