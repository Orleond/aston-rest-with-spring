package com.example.restservisewithspring.mapper;

import com.example.restservisewithspring.dto.BrandDto;
import com.example.restservisewithspring.entity.BrandEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BrandMapperTest {

    @Test
    void mapToBrandDto() {
        BrandEntity brandEntity = new BrandEntity(1, "Brand");
        BrandDto brandDto = BrandMapper.mapToBrandDto(brandEntity);
        assertEquals(BrandDto.of(1, "Brand"), brandDto);
    }

    @Test
    void mapToBrandEntity() {
        var brandDto = BrandDto.of(1, "Brand");
        var brandEntity = BrandMapper.mapToBrandEntity(brandDto);
        assertEquals(new BrandEntity(1, "Brand"), brandEntity);
    }
}