package com.example.restservisewithspring.mapper;

import com.example.restservisewithspring.dto.ProductDto;
import com.example.restservisewithspring.dto.TypeDto;
import com.example.restservisewithspring.entity.ModelEntity;
import com.example.restservisewithspring.entity.ProductEntity;
import com.example.restservisewithspring.entity.TypeEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    @Test
    void mapToProductDto() {
        var productEntity = new ProductEntity(1, 1, 1, 1, new BigDecimal(99.9));
        var productDto = ProductMapper.mapToProductDto(productEntity);
        assertEquals(ProductDto.of(1, 1, 1, 1, new BigDecimal(99.9)),
                productDto);
    }

    @Test
    void mapToProductEntity() {
        var productDto =
                ProductDto.of(1, 1, 1, 1, new BigDecimal(99.9));
        var productEntity = ProductMapper.mapToProductEntity(productDto);
        assertEquals(new ProductEntity(1, 1, 1, 1, new BigDecimal(99.9)),
                productEntity);
    }
}