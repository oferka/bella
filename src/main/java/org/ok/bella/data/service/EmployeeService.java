package org.ok.bella.data.service;

import org.ok.bella.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();

    Optional<Employee> findById(String id);

    long count();

    Employee save(Employee employee);

    void deleteById(String id);

    boolean existsById(String id);
}
