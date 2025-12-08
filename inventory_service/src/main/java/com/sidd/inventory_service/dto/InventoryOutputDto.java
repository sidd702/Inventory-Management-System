package com.sidd.inventory_service.dto;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryOutputDto {
    private Long productId;
    private Long updatedQuantity;
    private String warehouseLocation;
    private Instant updatedAt;
}
