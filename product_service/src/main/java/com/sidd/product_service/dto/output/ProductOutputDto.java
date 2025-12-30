package com.sidd.product_service.dto.output;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductOutputDto {
    private Long id;
    private String prd_name;
    private Long prd_category;
    private Long prd_price;
    //private Long prd_quantity;
}
