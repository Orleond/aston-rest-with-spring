package com.example.restservisewithspring.repository;

import com.example.restservisewithspring.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ModelRepository extends JpaRepository<ModelEntity, Integer> {
    @Modifying
    @Query("UPDATE ModelEntity SET name = :name WHERE id = :id")
    void changeModel(int id, String name);
}