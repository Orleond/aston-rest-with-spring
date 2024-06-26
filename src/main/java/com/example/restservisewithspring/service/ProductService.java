package com.example.restservisewithspring.service;

import com.example.restservisewithspring.dto.ProductDto;
import com.example.restservisewithspring.entity.ProductEntity;
import com.example.restservisewithspring.mapper.ProductMapper;
import com.example.restservisewithspring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

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
}
