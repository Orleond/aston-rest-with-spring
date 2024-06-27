package com.example.restservisewithspring.service;

import com.example.restservisewithspring.dto.ProductDto;
import com.example.restservisewithspring.entity.ProductEntity;
import com.example.restservisewithspring.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductDto productDto;

    @InjectMocks
    private ProductService productService;

    private final ProductDto testProductDto =
            ProductDto.of(1, 1, 1, 1, new BigDecimal("99.99"));
    private final ProductEntity testProductEntity =
            new ProductEntity(1, 1, 1, 1, new BigDecimal("99.99"));

    @Test
    void getAllProducts() {
        given(productRepository.findAll())
                .willReturn(List.of(testProductEntity));

        var allProducts = productService.getAllProducts();
        assertEquals(List.of(testProductDto), allProducts);
    }

    @Test
    void getProduct() {
        given(productRepository.findById(1))
                .willReturn(Optional.of(testProductEntity));

        var product = productService.getProduct(1);

        assertEquals(testProductDto, product);
    }

    @Test
    void postProduct() {
        given(productRepository.save(testProductEntity)).willReturn(testProductEntity);
        var productDto1 = productService.postProduct(testProductDto);
        assertEquals(testProductDto, productDto1);
    }

    @Test
    void putProduct() {
        given(productRepository.findById(1))
            .willReturn(Optional.of(testProductEntity));
        var productDto1 = productService.putProduct(testProductDto);
        assertEquals(testProductDto, productDto1);
    }

    @Test
    void deleteProduct() {
        var b = productService.deleteProduct(testProductDto);
        assertEquals(true, b);
    }
}