package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.controller.WebController;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
@SpringBootApplication
//@ComponentScan(basePackages={"com.example.demo.ProductServiceimpl"})
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {
		log.debug("Inside the spring boot main method");
		SpringApplication.run(DemoApplication.class, args);
	}

}
