package org.ok.bella.data.service;

import org.ok.bella.data.repository.es.EmployeeElasticsearchRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceElasticsearch implements EmployeeService {

    private final EmployeeElasticsearchRepository employeeElasticsearchRepository;

    public EmployeeServiceElasticsearch(EmployeeElasticsearchRepository employeeElasticsearchRepository) {
        this.employeeElasticsearchRepository = employeeElasticsearchRepository;
    }

    @Override
    public long count() {
        return employeeElasticsearchRepository.count();
    }
}
