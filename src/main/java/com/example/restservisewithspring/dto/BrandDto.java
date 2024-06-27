package com.example.restservisewithspring.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
public class BrandDto {
    private Integer id;
    private String name;

    private BrandDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static BrandDto of(Integer id, String name) {
        return new BrandDto(id, name);
    }
}
