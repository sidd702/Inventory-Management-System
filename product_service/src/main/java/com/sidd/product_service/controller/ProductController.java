package com.sidd.product_service.controller;

import com.sidd.product_service.dto.input.ProductInputDto;
import com.sidd.product_service.dto.output.ProductOutputDto;
import com.sidd.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    private ResponseEntity<?> getAllProducts() {
        List<ProductOutputDto> outputDtoList = this.productService.getAllProducts();
        if (outputDtoList == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empty Inventory");
        } else {
            return new ResponseEntity<>(
                    outputDtoList,
                    HttpStatus.FOUND
            );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        ProductOutputDto fetchPrd = this.productService.getProductById(id);
        if (fetchPrd != null) {
            return new ResponseEntity<>(
                    fetchPrd,
                    HttpStatus.FOUND
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Product Id " + id + " NOT FOUND");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProducts(@RequestBody List<ProductInputDto> productInputDtoList) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.productService.addProducts(productInputDtoList));
    }
}
