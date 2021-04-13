package org.ok.bella.data.service;

import org.ok.bella.data.repository.es.EmployeeElasticsearchRepository;
import org.ok.bella.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceElasticsearch implements EmployeeService {

    private final EmployeeElasticsearchRepository employeeElasticsearchRepository;

    public EmployeeServiceElasticsearch(EmployeeElasticsearchRepository employeeElasticsearchRepository) {
        this.employeeElasticsearchRepository = employeeElasticsearchRepository;
    }

    @Override
    public List<Employee> findAll() {
        Iterable<Employee> employees = employeeElasticsearchRepository.findAll();
        return StreamSupport
                .stream(employees.spliterator(), false)
                .collect(Collectors.toList());
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
    public Iterable<Employee> save(Iterable<Employee> employees) {
        return employeeElasticsearchRepository.saveAll(employees);
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
