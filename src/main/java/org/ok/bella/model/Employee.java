package org.ok.bella.model;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Objects;

import static org.springframework.data.elasticsearch.annotations.FieldType.Keyword;

@Document(indexName = "bella_employee")
public class Employee extends Entity {

    @Getter
    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    @Field(type = Keyword)
    private final String title;

    public Employee(String id, String name, String title) {
        super(id, name);
        this.title = title;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
