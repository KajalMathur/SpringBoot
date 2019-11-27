package com.product.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.CustomerProductResponse;
import com.product.service.CustomerProductService;

@RestController
@RequestMapping("/api")
public class CustomerProductController {

	private CustomerProductService customerProductService;

	@Autowired
	CustomerProductController(CustomerProductService customerProductService) {
		this.customerProductService = customerProductService;
	}

	@GetMapping("/customer/{customerId}/product/{productId}")
	public CustomerProductResponse getCustomerProduct(@PathVariable int customerId, @PathVariable int productId)
			throws MalformedURLException {
		return customerProductService.getcustometerProductById(customerId, productId);
	}
}
