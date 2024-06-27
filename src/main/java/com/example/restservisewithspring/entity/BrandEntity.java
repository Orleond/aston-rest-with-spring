package com.example.restservisewithspring.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "brand", schema = "public")
@EqualsAndHashCode
public class BrandEntity {
    @Id
    private Integer id;
    private String name;
}
