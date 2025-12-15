package com.sidd.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorResponse {
    private String status;
    private String message;
    private Instant timestamp;
}
