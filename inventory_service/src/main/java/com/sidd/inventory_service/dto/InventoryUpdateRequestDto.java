package com.sidd.inventory_service.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryUpdateRequestDto {
    private Long prd_id;
    //negative if stock reduces
    private Boolean addQuantity;
    private Long quantity;
    private String warehouseLocation;
}
