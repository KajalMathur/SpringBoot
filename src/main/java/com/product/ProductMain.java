package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ProductMain {
	public static void main(String[] args) {
		log.info("Spring Boot Project");
		SpringApplication.run(ProductMain.class, args);
	}
}
