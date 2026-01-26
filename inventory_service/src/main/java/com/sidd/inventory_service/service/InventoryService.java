package com.sidd.inventory_service.service;

import com.sidd.common.events.OrderCreatedEvent;
import com.sidd.common.events.OrderProcessedEvent;
import com.sidd.inventory_service.dto.InventoryOutputDto;
import com.sidd.inventory_service.dto.InventoryUpdateRequestDto;
import com.sidd.inventory_service.entity.InventoryEntity;
import com.sidd.inventory_service.mappers.InventoryMapper;
import com.sidd.inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class InventoryService {
    private final InventoryMapper inventoryMapper;
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryMapper inventoryMapper, InventoryRepository inventoryRepository) {
        this.inventoryMapper = inventoryMapper;
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryOutputDto addStock(InventoryUpdateRequestDto inventoryUpdateRequestDto) {

        InventoryEntity entity = this.inventoryMapper.dtoToEntity(inventoryUpdateRequestDto);
        entity.setCreated_at(Instant.now());
        entity.setUpdatedAt(Instant.now());

        return this.inventoryMapper.entityToDto(
                this.inventoryRepository.addStock(entity));
    }

    public OrderProcessedEvent newOrder(OrderCreatedEvent event) {
        InventoryEntity entity = this.inventoryRepository.findInventoryByPrdId(event.getPrdId());
        String orderStatus;
        if (entity.getQuantity() >= event.getQuantity()) {
            entity.setQuantity(entity.getQuantity() - event.getQuantity());  // Simple!
            entity = this.inventoryRepository.updateStock(entity);
            orderStatus = "PROCESSED";
        } else {
            orderStatus = "FAILED";
        }


       /* InventoryEntity entity= InventoryEntity.builder()
                .productId(event.getPrdId())
                .quantity(quantityToReduce)
                .warehouseLocation("Warehouse A")
                .created_at(Instant.now())
                .updatedAt(Instant.now())
                .build();

        entity = this.inventoryRepository.addStock(entity);
*/
        OrderProcessedEvent event2 = OrderProcessedEvent.builder()
                .orderId(event.getOrderId())
                .prdId(entity.getProductId())
                .orderStatus(orderStatus)
                .created_at(entity.getCreated_at())
                .updated_at(entity.getUpdatedAt())
                .quantity(event.getQuantity())
                .build();

        return event2;
    }

    public InventoryOutputDto findInventoryById(Long inventoryId) {
        return this.inventoryMapper.entityToDto(
                this.inventoryRepository.findInventoryById(inventoryId)
        );
    }
}
