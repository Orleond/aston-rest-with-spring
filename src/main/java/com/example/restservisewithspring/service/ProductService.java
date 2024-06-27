package com.example.restservisewithspring.service;

import com.example.restservisewithspring.dto.ProductDto;
import com.example.restservisewithspring.entity.ProductEntity;
import com.example.restservisewithspring.mapper.ProductMapper;
import com.example.restservisewithspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProducts() {
        var allProducts = productRepository.findAll();
        List<ProductDto> allProductsDto = new ArrayList<>();
        for (ProductEntity product : allProducts) {
            allProductsDto.add(ProductMapper.mapToProductDto(product));
        }
        return allProductsDto;
    }

    public ProductDto getProduct(int id) {
        var byId = productRepository.findById(id);
        return byId.map(ProductMapper::mapToProductDto).orElse(null);
    }

    public ProductDto postProduct(ProductDto productDto) {
        var productEntity = ProductMapper.mapToProductEntity(productDto);
        var savedProductEntity = productRepository.save(productEntity);
        return ProductMapper.mapToProductDto(savedProductEntity);
    }

    @Transactional
    public ProductDto putProduct(ProductDto productDto) {
        var originProductDto = getProduct(productDto.getProductId());
        Integer typeId = productDto.getTypeId();
        Integer brandId = productDto.getBrandId();
        Integer modelId = productDto.getModelId();
        BigDecimal price = productDto.getPrice();
        if (typeId != null) originProductDto.setTypeId(typeId);
        if (brandId != null) originProductDto.setBrandId(brandId);
        if (modelId != null) originProductDto.setModelId(modelId);
        if (price != null) originProductDto.setPrice(price);
        productRepository.changeProduct(originProductDto.getProductId(),
                originProductDto.getTypeId(),
                originProductDto.getBrandId(),
                originProductDto.getModelId(),
                originProductDto.getPrice());
        return originProductDto;
    }

    public boolean deleteProduct(ProductDto productDto) {
        var productEntity = ProductMapper.mapToProductEntity(productDto);
        try {
            productRepository.delete(productEntity);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }
}
