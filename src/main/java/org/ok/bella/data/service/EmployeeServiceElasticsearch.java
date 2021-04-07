package org.ok.bella.data.service;

import org.ok.bella.data.repository.es.EmployeeElasticsearchRepository;
import org.ok.bella.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Optional<Employee> findById(String id) {
        return employeeElasticsearchRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeElasticsearchRepository.save(employee);
    }

    @Override
    public void deleteById(String id) {
        employeeElasticsearchRepository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return employeeElasticsearchRepository.existsById(id);
    }

    @Override
    public long count() {
        return employeeElasticsearchRepository.count();
    }
}
