package com.sidd.product_service.service;

import com.sidd.product_service.dto.input.ProductInputDto;
import com.sidd.product_service.dto.output.ProductOutputDto;
import com.sidd.product_service.entities.ProductEntity;
import com.sidd.product_service.mappers.ProductMapper;
import com.sidd.product_service.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ProductService {
    private final ProductsRepository productsRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductsRepository productsRepository, ProductMapper productMapper) {
        this.productsRepository = productsRepository;
        this.productMapper = productMapper;
    }

    @Autowired
    public List<ProductOutputDto> getAllProducts() {
        return this.productMapper.entityToDtoList(this.productsRepository.getAllProducts());
    }

    public ProductOutputDto getProductById(Long id) {
        return ProductMapper.entityToDto(this.productsRepository.getProductById(id));
    }

    public List<ProductOutputDto> addProducts(List<ProductInputDto> productInputDtoList) {
        List<ProductEntity> productEntityList = this.productMapper.dtoListToEntityList(productInputDtoList);
        for (ProductEntity prd : productEntityList) {
            prd.setCreated_at(Instant.now());
            prd.setUpdated_at(Instant.now());
        }
        return this.productMapper.entityToDtoList(this.productsRepository.saveAllProducts(productEntityList));
    }
}
