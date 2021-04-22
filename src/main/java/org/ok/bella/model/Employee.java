package org.ok.bella.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "bella_employee")
public class Employee extends Entity {

    public Employee(String id, String name) {
        super(id, name);
    }
}
