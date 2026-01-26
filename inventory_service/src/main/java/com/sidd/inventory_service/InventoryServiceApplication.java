package com.sidd.inventory_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);

        for (int i = 0; i < 5; i++) {
            System.out.println("---------------Inventory Service Running on PORT 8081---------------------");
        }
    }
}
