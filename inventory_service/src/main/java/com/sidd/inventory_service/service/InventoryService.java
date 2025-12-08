package com.sidd.inventory_service.service;

import com.sidd.inventory_service.dto.InventoryOutputDto;
import com.sidd.inventory_service.dto.InventoryUpdateRequestDto;
import com.sidd.inventory_service.mappers.InventoryMapper;
import com.sidd.inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return this.inventoryMapper.entityToDto(
                this.inventoryRepository.addStock(
                        this.inventoryMapper.dtoToEntity(inventoryUpdateRequestDto)
                )
        );
    }
}
