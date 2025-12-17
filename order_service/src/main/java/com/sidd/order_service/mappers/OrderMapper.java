package com.sidd.order_service.mappers;

import com.sidd.order_service.dto.OrderInputDto;
import com.sidd.order_service.dto.OrderOutputDto;
import com.sidd.order_service.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderEntity dtoToEntity(OrderInputDto inputDto){
        return OrderEntity.builder()
                .prdId(inputDto.getPrdId())
                .prdQuantity(inputDto.getPrdQuantity())
                .build();
    }

    public OrderOutputDto entityToDto(OrderEntity orderEntity){
        return OrderOutputDto.builder()
                .orderId(orderEntity.getOrderId())
                .prdId(orderEntity.getPrdId())
                .prdQuantity(orderEntity.getPrdQuantity())
                .orderStatus(orderEntity.getOrderStatus())
                .created_at(orderEntity.getCreated_at())
                .updated_at(orderEntity.getCreated_at())
                .build();
    }
}
