package com.sidd.order_service.service;

import com.sidd.order_service.dto.OrderInputDto;
import com.sidd.order_service.dto.OrderOutputDto;
import com.sidd.order_service.entity.OrderEntity;
import com.sidd.order_service.mappers.OrderMapper;
import com.sidd.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }

    public OrderOutputDto createNewOrder(OrderInputDto inputDto) {
        OrderEntity orderEntity = this.orderMapper.dtoToEntity(inputDto);
        orderEntity.setOrderStatus("CREATED");
        orderEntity.setCreated_at(Instant.now());
        orderEntity.setUpdated_at(Instant.now());

        return this.orderMapper.entityToDto(
                this.orderRepository.createOrder(orderEntity)
        );
    }
}
