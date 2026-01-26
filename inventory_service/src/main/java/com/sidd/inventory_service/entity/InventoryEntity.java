package com.sidd.inventory_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long inventoryId;

    @Column(name = "prd_id", nullable = false)
    private Long productId;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "warehouse",  length = 20)
    private String warehouseLocation;

    @Column(name = "low_stock_threshold")
    private Long lowStockThreshold;

    @Column(name = "created_at")
    private Instant created_at;

    @Column(name = "updated_at")
    private Instant updatedAt;
}
