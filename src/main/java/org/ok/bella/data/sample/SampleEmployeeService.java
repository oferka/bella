package org.ok.bella.data.sample;

import org.ok.bella.model.Employee;

public interface SampleEmployeeService {

    Iterable<Employee> load();
}
