package com.example.restservisewithspring.mapper;

import com.example.restservisewithspring.dto.ModelDto;
import com.example.restservisewithspring.dto.TypeDto;
import com.example.restservisewithspring.entity.ModelEntity;
import com.example.restservisewithspring.entity.TypeEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeMapperTest {

    @Test
    void mapToTypeDto() {
        var typeEntity = new TypeEntity(1, "Type");
        var typeDto = TypeMapper.mapToTypeDto(typeEntity);
        assertEquals(TypeDto.of(1, "Type"), typeDto);
    }

    @Test
    void mapToTypeEntity() {
        var typeDto = TypeDto.of(1, "Type");
        var typeEntity = TypeMapper.mapToTypeEntity(typeDto);
        assertEquals(new TypeEntity(1, "Type"), typeEntity);
    }
}