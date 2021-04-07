package org.ok.bella.data.service;

import org.ok.bella.model.Employee;

import java.util.List;

public interface EmployeeService {

    Iterable<Employee> findAll();

    long count();
}
