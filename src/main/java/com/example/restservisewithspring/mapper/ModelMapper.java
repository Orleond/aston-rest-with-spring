package com.example.restservisewithspring.mapper;

import com.example.restservisewithspring.dto.ModelDto;
import com.example.restservisewithspring.entity.ModelEntity;

public class ModelMapper {
    public static ModelDto mapToModelDto(ModelEntity modelEntity) {
        return ModelDto.of(modelEntity.getId(),
                modelEntity.getName());
    }

    public static ModelEntity mapToModelEntity(ModelDto modelDto) {
        return new ModelEntity (modelDto.getId(),
                modelDto.getName());
    }
}
