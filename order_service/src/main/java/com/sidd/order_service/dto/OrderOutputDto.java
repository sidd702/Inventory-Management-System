package com.sidd.order_service.dto;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderOutputDto {
    private Long orderId;
    private Long prdId;
    private Long prdQuantity;
    private String orderStatus;
    private Instant created_at;
    private Instant updated_at;
}