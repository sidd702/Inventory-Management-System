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

    @Column(name = "warehouse", nullable = false, length = 10)
    private String warehouseLocation;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "low_stock_threshold", nullable = false)
    private Long lowStockThreshold;
}
