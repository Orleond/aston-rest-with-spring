package com.example.restservisewithspring.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ModelDto {
    private Integer id;
    private String name;

    private ModelDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ModelDto of(Integer id, String name) {
        return new ModelDto(id, name);
    }
}
