package com.example.restservisewithspring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeDto {
    private Integer id;
    private String name;

    private TypeDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TypeDto of(Integer id, String name) {
        return new TypeDto(id, name);
    }
}
