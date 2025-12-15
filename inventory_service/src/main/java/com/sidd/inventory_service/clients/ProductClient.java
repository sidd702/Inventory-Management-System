package com.sidd.inventory_service.clients;

import com.sidd.inventory_service.dto.external.ProductResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductClient {
    @GetMapping("/products/{id}")
    public  ProductResponseDto getProductById(@PathVariable("id") Long prd_id);
    }

