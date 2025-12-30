package com.sidd.product_service.repository.jpa;

import com.sidd.product_service.entities.CategoryEntity;
import com.sidd.product_service.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    public List<ProductEntity> findByPrdCategory(CategoryEntity category);
}
