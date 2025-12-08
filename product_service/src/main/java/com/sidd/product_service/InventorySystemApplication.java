package com.sidd.product_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventorySystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventorySystemApplication.class, args);
        System.out.println("Inventory System is " +
                "running----------------------------------------------------------------");
	}
}
