package com.example.restservisewithspring.mapper;

import com.example.restservisewithspring.dto.ProductDto;
import com.example.restservisewithspring.entity.ProductEntity;

public class ProductMapper {
    public static ProductDto mapToProductDto(ProductEntity productEntity) {
        return ProductDto.of(productEntity.getId(),
                productEntity.getTypeId(),
                productEntity.getBrandId(),
                productEntity.getModelId(),
                productEntity.getPrice());
    }

    public static ProductEntity mapToProductEntity(ProductDto productDto) {
//        return new ProductEntity (productDto.getProductId(),
//                productDto.getTypeId(),
//                productDto.getBrandId(),
//                productDto.getModelId(),
//                productDto.getPrice());
        return null;
    }
}
