package com.example.restservisewithspring.mapper;

import com.example.restservisewithspring.dto.TypeDto;
import com.example.restservisewithspring.entity.TypeEntity;

public class TypeMapper {
    public static TypeDto mapToTypeDto(TypeEntity typeEntity) {
        return TypeDto.of(typeEntity.getId(),
                typeEntity.getName());
    }

    public static TypeEntity mapToTypeEntity(TypeDto typeDto) {
        return new TypeEntity (typeDto.getId(),
                typeDto.getName());
    }
}
