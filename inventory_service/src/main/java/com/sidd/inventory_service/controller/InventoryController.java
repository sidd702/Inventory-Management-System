package com.sidd.inventory_service.controller;

import com.sidd.inventory_service.dto.InventoryOutputDto;
import com.sidd.inventory_service.dto.InventoryUpdateRequestDto;
import com.sidd.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getByInventoryId(@PathVariable("id") Long inventoryId){
        InventoryOutputDto fetchInventory =this.inventoryService.findInventoryById(inventoryId);
        if(fetchInventory!=null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(fetchInventory);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(inventoryId+" inventory Id Not Found");
        }

    }
}
