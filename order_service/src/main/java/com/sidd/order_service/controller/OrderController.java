package com.sidd.order_service.controller;

import com.sidd.order_service.dto.OrderInputDto;
import com.sidd.order_service.dto.OrderOutputDto;
import com.sidd.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/new")
    public ResponseEntity<OrderOutputDto> createNewOrder(@RequestBody OrderInputDto inputDto) {
        return ResponseEntity.ok(
                this.orderService.createNewOrder(inputDto)
        );
    }
}
