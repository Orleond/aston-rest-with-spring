package com.example.restservisewithspring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product", schema = "public")
@EqualsAndHashCode
public class ProductEntity {
    @Id
    private int id;
    private int typeId;
    private int brandId;
    private int modelId;
    private BigDecimal price;
}
