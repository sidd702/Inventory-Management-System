package com.sidd.inventory_service.repository;

import com.sidd.inventory_service.entity.InventoryEntity;
import com.sidd.inventory_service.exceptions.ResourceNotFoundException;
import com.sidd.inventory_service.repository.jpa.InventoryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InventoryRepository {
    private final InventoryJpaRepository inventoryJpaRepository;

    @Autowired
    public InventoryRepository(InventoryJpaRepository inventoryJpaRepository) {
        this.inventoryJpaRepository = inventoryJpaRepository;
    }

    public InventoryEntity addStock(InventoryEntity entity) {
        return this.inventoryJpaRepository.save(entity);
    }

    public InventoryEntity updateStock(InventoryEntity entity) {
        return this.inventoryJpaRepository.save(entity);
    }

    public InventoryEntity findInventoryByPrdId(Long prdId){
        Optional<InventoryEntity> optional = this.inventoryJpaRepository.findByProductId(prdId);
        return optional.orElseThrow(() -> new ResourceNotFoundException(prdId + " Product Id Not Found"));
    }

    public InventoryEntity findInventoryById(Long inventoryId) {
        Optional<InventoryEntity> optional = this.inventoryJpaRepository.findById(inventoryId);
        return optional.orElseThrow(() -> new ResourceNotFoundException(inventoryId + " Inventory Id Not Found"));
    }
}
