package com.sidd.product_service.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInputDto {
    //input entity come into system
    private String prd_name;
    private String prd_category;
    private Long prd_price;
    private Long prd_quantity;
}