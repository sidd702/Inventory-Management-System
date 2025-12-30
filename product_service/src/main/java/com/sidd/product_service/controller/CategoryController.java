package com.sidd.product_service.controller;

import com.sidd.product_service.entities.CategoryEntity;
import com.sidd.product_service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<List<CategoryEntity>> addCategory(@RequestBody List<CategoryEntity> categoryEntityList) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.categoryService.addAllCategory(categoryEntityList));
    }

}
