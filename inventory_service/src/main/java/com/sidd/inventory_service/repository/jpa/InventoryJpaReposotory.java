package com.sidd.inventory_service.repository.jpa;

import com.sidd.inventory_service.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryJpaReposotory extends JpaRepository<InventoryEntity, Long> {
    Optional<InventoryEntity> findByProductIdGreaterThan(Long productId);

    Optional<InventoryEntity> findByProductIdNotNull();
}
