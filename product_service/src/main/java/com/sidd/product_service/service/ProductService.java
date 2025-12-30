package com.sidd.product_service.service;

import com.sidd.product_service.customannotation.LogExecutionTime;
import com.sidd.product_service.dto.input.ProductInputDto;
import com.sidd.product_service.dto.output.ProductOutputDto;
import com.sidd.product_service.entities.CategoryEntity;
import com.sidd.product_service.entities.ProductEntity;
import com.sidd.product_service.mappers.ProductMapper;
import com.sidd.product_service.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private final ProductsRepository productsRepository;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;

    @Autowired
    public ProductService(ProductsRepository productsRepository, ProductMapper productMapper, CategoryService categoryService) {
        this.productsRepository = productsRepository;
        this.productMapper = productMapper;
        this.categoryService = categoryService;
    }


    public List<ProductOutputDto> getProductsByCategory(String category) throws Exception {
        CategoryEntity categoryEntity = this.categoryService.findByCategoryName(category);
        List<ProductEntity> productEntities = this.productsRepository.findByPrdCategory(categoryEntity);

        return this.productMapper.entityToDtoList(productEntities);
    }

    @LogExecutionTime
    public Map<String, Object> getProductsBySortedPage(int page, int size) {
        String sortBy = "id";
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        Page<ProductEntity> entityPage = this.productsRepository.getAllProductsPaginated(pageable);
        List<ProductOutputDto> dtoList = this.productMapper.entityToDtoList(entityPage.getContent());

        Map<String, Object> response = new HashMap<>();
        response.put("ProductOutputDto", dtoList);
        response.put("currentPage", pageable.getPageNumber());
        response.put("totalPages", entityPage.getTotalPages());
        response.put("totalElements", entityPage.getTotalElements());
        response.put("pageSize", entityPage.getSize());
        response.put("isFirst", entityPage.isFirst());
        response.put("isLast", entityPage.isLast());

        return response;

    }

    public List<ProductOutputDto> getAllProducts() {
        return this.productMapper.entityToDtoList(this.productsRepository.getAllProducts());
    }

    public ProductOutputDto getProductById(Long id) {
        return ProductMapper.entityToDto(this.productsRepository.getProductById(id));
    }

    public List<ProductOutputDto> addProducts(List<ProductInputDto> productInputDtoList) {
        List<ProductEntity> productEntityList = this.productMapper.dtoListToEntityList(productInputDtoList);
        for (ProductEntity prd : productEntityList) {
            /*
            Tax Calculation
             */

            prd.setCreatedAt(Instant.now());
            prd.setUpdatedAt(Instant.now());
        }
        return this.productMapper.entityToDtoList(this.productsRepository.saveAllProducts(productEntityList));
    }
}
