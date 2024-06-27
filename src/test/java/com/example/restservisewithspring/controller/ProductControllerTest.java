package com.example.restservisewithspring.controller;

import com.example.restservisewithspring.dto.ProductDto;
import com.example.restservisewithspring.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private ProductDto productDto;

    @InjectMocks
    private ProductController productController;

    @Test
    void getProduct() {
        given(productService.getProduct(1))
                .willReturn(ProductDto.of(1, 2, 1, 1, new BigDecimal("99.91")));

        var product = productController.getProduct(1);
        assertEquals(ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(productService.getProduct(1)), product);
    }

    @Test
    void postProduct() {
        given(productService.postProduct(productDto))
                .willReturn(ProductDto.of(1, 2, 1, 1, new BigDecimal("99.91")));
        var productDtoResponseEntity = productController.postProduct(productDto);

        assertEquals(ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(productService.postProduct(productDto)), productDtoResponseEntity);
    }

    @Test
    void putProduct() {
        var productDtoResponseEntity =
                productController.putProduct(1, 1, 1, 1, null);

        assertEquals(ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(productService.putProduct(productDto)), productDtoResponseEntity);
    }

    @Test
    void deleteProduct() {
        given(productService.getProduct(1))
                .willReturn(ProductDto.of(1, 2, 1, 1, new BigDecimal("99.91")));
        given(productService.deleteProduct(productService.getProduct(1)))
                .willReturn(true);

        var booleanResponseEntity = productController.deleteProduct(1);
        assertEquals(ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(productService.deleteProduct(productService.getProduct(1))), booleanResponseEntity);
    }

    @Test
    void getAllProducts() {
        var productDto1 = ProductDto.of(1, 2, 1, 1, new BigDecimal("99.91"));
        given(productService.getAllProducts())
                .willReturn(List.of(productDto1));
        var allProducts = productController.getAllProducts();

        assertEquals(List.of(productDto1), allProducts);
    }
}