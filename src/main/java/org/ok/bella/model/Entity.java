package org.ok.bella.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static org.springframework.data.elasticsearch.annotations.FieldType.Keyword;

@EqualsAndHashCode
public abstract class Entity {

    @Id
    @Getter
    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    @Field(type = Keyword)
    private final String id;

    @Getter
    @NotNull
    @Size(min = 2, max = 64)
    @NotBlank
    @Field(type = Keyword)
    private final String name;

    public Entity(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
