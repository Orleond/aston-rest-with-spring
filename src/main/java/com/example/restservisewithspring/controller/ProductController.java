package com.example.restservisewithspring.controller;

import com.example.restservisewithspring.dto.ProductDto;
import com.example.restservisewithspring.entity.ProductEntity;
import com.example.restservisewithspring.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable int id) {
        var productDto = ProductDto.of(1, 1, 1, 1, new BigDecimal(199.99));
        if (productDto.getProductId() == id)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDto);
        return ResponseEntity.badRequest().body(null);
    }

    @PostMapping("/")
    public ResponseEntity<ProductDto> postProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDto> putProduct(@PathVariable int id,
                                                 @RequestParam(required = false) Integer typeId,
                                                 @RequestParam(required = false) Integer brandId,
                                                 @RequestParam(required = false) Integer modelId,
                                                 @RequestParam(required = false) BigDecimal price) {
        try {
            ProductDto productDto = ProductDto.of(id, 1, 1, 1, new BigDecimal(199.99));
            if (typeId != null) productDto.setTypeId(typeId);
            if (brandId != null) productDto.setBrandId(brandId);
            if (modelId != null) productDto.setModelId(modelId);
            if (price != null) productDto.setPrice(price);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDto);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable int id) {
        var productDto = ProductDto.of(1, 1, 1, 1, new BigDecimal(199.99));
        if (productDto.getProductId() == id) {
            productDto = null;
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDto);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping(value = "/all")
    public Iterable<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

}
