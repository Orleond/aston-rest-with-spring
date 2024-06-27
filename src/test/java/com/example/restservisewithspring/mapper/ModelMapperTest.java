package com.example.restservisewithspring.mapper;

import com.example.restservisewithspring.dto.BrandDto;
import com.example.restservisewithspring.dto.ModelDto;
import com.example.restservisewithspring.entity.BrandEntity;
import com.example.restservisewithspring.entity.ModelEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelMapperTest {

    @Test
    void mapToModelDto() {
        var modelEntity = new ModelEntity(1, "Model");
        var modelDto = ModelMapper.mapToModelDto(modelEntity);
        assertEquals(ModelDto.of(1, "Model"), modelDto);
    }

    @Test
    void mapToModelEntity() {
        var modelDto = ModelDto.of(1, "Model");
        var modelEntity = ModelMapper.mapToModelEntity(modelDto);
        assertEquals(new ModelEntity(1, "Model"), modelEntity);
    }
}