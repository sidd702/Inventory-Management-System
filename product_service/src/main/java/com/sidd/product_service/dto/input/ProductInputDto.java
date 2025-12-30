package com.sidd.product_service.dto.input;

import com.sidd.product_service.entities.CategoryEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductInputDto {
    //input entity come into system
    private String prdName;
    private Long prdPrice;
    private CategoryEntity prdCategory;
    //private Long prd_quantity;
}