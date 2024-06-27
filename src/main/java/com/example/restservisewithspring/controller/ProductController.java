package com.example.restservisewithspring.controller;

import com.example.restservisewithspring.dto.ProductDto;
import com.example.restservisewithspring.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable int id) {
        ProductDto product = productService.getProduct(id);
        if (product != null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
        return ResponseEntity.badRequest().body(null);
    }

    @PostMapping("/")
    public ResponseEntity<ProductDto> postProduct(@RequestBody ProductDto productDto) {
        var product = productService.postProduct(productDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDto> putProduct(@PathVariable int id,
                                                 @RequestParam(required = false) Integer typeId,
                                                 @RequestParam(required = false) Integer brandId,
                                                 @RequestParam(required = false) Integer modelId,
                                                 @RequestParam(required = false) BigDecimal price) {
        var productDto = ProductDto.of(id, null, null, null, null);
        if (typeId != null) productDto.setTypeId(typeId);
        if (brandId != null) productDto.setBrandId(brandId);
        if (modelId != null) productDto.setModelId(modelId);
        if (price != null) productDto.setPrice(price);
        var returnedProductDto = productService.putProduct(productDto);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(returnedProductDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable int id) {
        var productDto = productService.getProduct(id);
        boolean isDeleting = productService.deleteProduct(productDto);
        if (isDeleting) return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
        return ResponseEntity.badRequest().body(false);
    }

    @GetMapping(value = "/all")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

}
