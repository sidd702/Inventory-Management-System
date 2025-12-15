package com.sidd.product_service.repository;

import com.sidd.product_service.entities.ProductEntity;
import com.sidd.product_service.exceptions.ResourceNotFoundException;
import com.sidd.product_service.repository.jpa.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductsRepository {
    private final ProductJpaRepository productJpaRepository;

    @Autowired
    public ProductsRepository(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    public Page<ProductEntity> getAllProductsPaginated(Pageable pageable) {
        return this.productJpaRepository.findAll(pageable);
    }

    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> prdList = this.productJpaRepository.findAll();
        return prdList.isEmpty() ? null : prdList;
    }

    public ProductEntity getProductById(Long id) {
        Optional<ProductEntity> optionalProducts = this.productJpaRepository.findById(id);
        return optionalProducts.orElseThrow(() -> new ResourceNotFoundException("Product of Id " + id + " not found."));
    }

    public List<ProductEntity> saveAllProducts(List<ProductEntity> productEntityList) {
        return this.productJpaRepository.saveAll(productEntityList);
    }
}
