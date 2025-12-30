package com.sidd.product_service.service;

import com.sidd.product_service.entities.CategoryEntity;
import com.sidd.product_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryEntity findByCategoryName(String name) throws Exception {
        Optional<CategoryEntity> optionalCategoryEntity = this.categoryRepository.findByName(name);

        if (optionalCategoryEntity.isEmpty()) {
            throw new Exception("Category " + name + " not found!");
        }
        return optionalCategoryEntity.get();
    }

    public List<CategoryEntity> addAllCategory(List<CategoryEntity> categoryEntityList) {
        return this.categoryRepository.saveAllCategory(categoryEntityList);
    }
}
