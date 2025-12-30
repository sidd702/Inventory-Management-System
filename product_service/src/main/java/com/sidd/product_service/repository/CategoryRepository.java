package com.sidd.product_service.repository;

import com.sidd.product_service.entities.CategoryEntity;
import com.sidd.product_service.repository.jpa.CategoryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    private final CategoryJpaRepository categoryJpaRepository;

    @Autowired
    public CategoryRepository(CategoryJpaRepository categoryJpaRepository) {
        this.categoryJpaRepository = categoryJpaRepository;
    }

    public List<CategoryEntity> saveAllCategory(List<CategoryEntity> entityList) {
        return this.categoryJpaRepository.saveAll(entityList);
    }

    public Optional<CategoryEntity> findByName(String category) {
        return this.categoryJpaRepository.findByName(category);
    }
}
