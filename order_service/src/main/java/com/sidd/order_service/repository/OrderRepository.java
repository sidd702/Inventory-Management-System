package com.sidd.order_service.repository;

import com.netflix.discovery.converters.Auto;
import com.sidd.order_service.entity.OrderEntity;
import com.sidd.order_service.repository.jpa.OrderJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    private final OrderJpaRepository orderJpaRepository;

    @Autowired
    public OrderRepository(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    public OrderEntity createOrder(OrderEntity orderEntity){
        return this.orderJpaRepository.save(orderEntity);
    }
}
