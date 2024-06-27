package com.example.restservisewithspring.mapper;

import com.example.restservisewithspring.dto.BrandDto;
import com.example.restservisewithspring.entity.BrandEntity;

public class BrandMapper {
    public static BrandDto mapToBrandDto(BrandEntity brandEntity) {
        return BrandDto.of(brandEntity.getId(),
                brandEntity.getName());
    }

    public static BrandEntity mapToBrandEntity(BrandDto brandDto) {
        return new BrandEntity (brandDto.getId(),
                brandDto.getName());
    }
}
