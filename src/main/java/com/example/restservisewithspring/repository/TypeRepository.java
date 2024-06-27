package com.example.restservisewithspring.repository;

import com.example.restservisewithspring.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TypeRepository extends JpaRepository<TypeEntity, Integer> {
    @Modifying
    @Query("UPDATE TypeEntity SET name = :name WHERE id = :id")
    void changeType(String name);
}
