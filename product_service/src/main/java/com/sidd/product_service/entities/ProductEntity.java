package com.sidd.product_service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "inv_products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prd_id", nullable = false)
    private Long id;

    @Column(name = "prd_name", nullable = false, length = 50)
    private String prd_name;

    @Column(name = "prd_category", nullable = false, length = 50)
    private String prd_category;

    @Column(name = "prd_price", nullable = false)
    private Long prd_price;

    /*
    Removing quantity from product to inventory
    at multiple loc will have some quantity of products

    @Column(name = "quantity", nullable = false)
    private Long prd_quantity;
*/

    @Column(name = "created_at")
    private Instant created_at;

    @Column(name = "updated_at")
    private Instant updated_at;
}
