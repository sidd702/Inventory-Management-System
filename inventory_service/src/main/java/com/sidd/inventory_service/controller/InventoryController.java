package com.sidd.inventory_service.controller;

import com.sidd.inventory_service.dto.InventoryUpdateRequestDto;
import com.sidd.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStock(@RequestBody InventoryUpdateRequestDto inventoryUpdateRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.inventoryService.addStock(inventoryUpdateRequestDto));
    }
}
