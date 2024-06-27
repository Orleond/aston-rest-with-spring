package com.example.restservisewithspring.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@EqualsAndHashCode
public class ProductDto {
    private Integer productId;
    private Integer typeId;
    private Integer brandId;
    private Integer modelId;
    private BigDecimal price;

    private ProductDto(int productId, Integer typeId, Integer brandId, Integer modelId, BigDecimal price) {
        this.productId = productId;
        this.typeId = typeId;
        this.brandId = brandId;
        this.modelId = modelId;
        this.price = price;
    }

    public static ProductDto of(Integer productId, Integer typeId, Integer brandId, Integer modelId, BigDecimal price) {
        return new ProductDto(productId, typeId, brandId, modelId, price);
    }

    public static ProductDto of(ProductDto productDto) {
        return new ProductDto(productDto.getProductId(), productDto.getTypeId(), productDto.getBrandId(),
                productDto.getModelId(), productDto.getPrice());
    }
}
