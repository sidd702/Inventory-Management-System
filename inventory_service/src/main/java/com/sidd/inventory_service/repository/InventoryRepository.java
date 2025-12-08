package com.sidd.inventory_service.repository;

import com.sidd.inventory_service.entity.InventoryEntity;
import com.sidd.inventory_service.repository.jpa.InventoryJpaReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryRepository {
    private final InventoryJpaReposotory inventoryJpaReposotory;

    @Autowired
    public InventoryRepository(InventoryJpaReposotory inventoryJpaReposotory) {
        this.inventoryJpaReposotory = inventoryJpaReposotory;
    }

    public InventoryEntity addStock(InventoryEntity entity) {
        return this.inventoryJpaReposotory.save(entity);
    }

    public Boolean findProductById(Long prd_id){
        return this.inventoryJpaReposotory.existsById(prd_id);
    }

}
