package com.sidd.inventory_service.mappers;

import com.sidd.inventory_service.dto.InventoryOutputDto;
import com.sidd.inventory_service.dto.InventoryUpdateRequestDto;
import com.sidd.inventory_service.entity.InventoryEntity;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {
    public InventoryEntity dtoToEntity(InventoryUpdateRequestDto dto) {
        return InventoryEntity.builder()
                .productId(dto.getPrd_id())
                .warehouseLocation(dto.getWarehouseLocation())
                .quantity(dto.getQuantity())
                .build();
    }

    public InventoryOutputDto entityToDto(InventoryEntity entity) {
        return InventoryOutputDto.builder()
                .productId(entity.getProductId())
                .updatedQuantity(entity.getQuantity())
                .updatedAt(entity.getUpdatedAt())
                .warehouseLocation(entity.getWarehouseLocation())
                .build();
    }

}
