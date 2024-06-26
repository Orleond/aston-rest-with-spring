package com.example.restservisewithspring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
