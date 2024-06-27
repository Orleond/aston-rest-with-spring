package com.example.restservisewithspring.repository;

import com.example.restservisewithspring.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Modifying
    @Query("UPDATE ProductEntity SET typeId = :typeId, " +
            "brandId = :brandId, modelId = :modelId, price = :price where id = :id")
    ProductEntity changeProduct(int id, int typeId, int brandId, int modelId, BigDecimal price);
}
