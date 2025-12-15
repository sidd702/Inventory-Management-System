package com.sidd.inventory_service.dto.external;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProductResponseDto {
    private Long id;
    private String prd_name;
    private String prd_category;
    private Long prd_price;
    //private Long prd_quantity;
}
