package com.sidd.product_service.controller;

import com.sidd.product_service.dto.input.ProductInputDto;
import com.sidd.product_service.dto.output.ProductOutputDto;
import com.sidd.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    //categories?category=electronics
    @GetMapping("/categories")
    public ResponseEntity<List<ProductOutputDto>> getProductsByCategory(@RequestParam String category) throws Exception {
        return ResponseEntity.ok(this.productService.getProductsByCategory(category));
    }

    //http://localhost:8080/products/pages?page=1&size=10
    @GetMapping("/pages")
    public ResponseEntity<Map<String, Object>> getProductsByPage
    (@RequestParam(defaultValue = "0") int page,
     @RequestParam(defaultValue = "50") int size) {

        return ResponseEntity.ok(this.productService.getProductsBySortedPage(page, size));
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
                    HttpStatus.OK
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
