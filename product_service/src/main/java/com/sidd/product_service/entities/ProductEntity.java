package com.sidd.product_service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "ps_products")
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
    private String prdName;
//    private String prdName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prd_category_id")
    private CategoryEntity prdCategory;

    @Column(name = "prd_price", nullable = false)
    private Long prdPrice;

/*    @Column(name = "prd_tax", nullable = false)
    private Long prdTax;*/

    /*
    Removing quantity from product to inventory
    at multiple loc will have some quantity of products

    @Column(name = "quantity", nullable = false)
    private Long prd_quantity;
*/

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;
}
