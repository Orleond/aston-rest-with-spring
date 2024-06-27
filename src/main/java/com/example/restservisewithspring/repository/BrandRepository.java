package com.example.restservisewithspring.repository;

import com.example.restservisewithspring.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {
    @Modifying
    @Query("UPDATE BrandEntity SET name = :name WHERE id = :id")
    BrandEntity changeBrand(int id, String name);
}
