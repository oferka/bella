package org.ok.bella.model;

import lombok.EqualsAndHashCode;
import org.springframework.data.elasticsearch.annotations.Document;

@EqualsAndHashCode
@Document(indexName = "bella_employee")
public class Employee extends Entity {

    public Employee(String id, String name) {
        super(id, name);
    }
}
