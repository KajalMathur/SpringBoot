package com.product.customerproductcontroller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.customerproductservice.CustomerProductService;
import com.product.model.CustomerProductResponse;

@RestController
@RequestMapping("/api")
public class CustomerProductController {
	
	private CustomerProductService customerProductService ;
	
	@Autowired
	CustomerProductController(CustomerProductService customerProductService) {
	this.customerProductService =customerProductService;
	}
	
	@GetMapping("/customerproduct/{id}")
	public CustomerProductResponse getCustomerProduct(@PathVariable int id) throws MalformedURLException {
		return customerProductService.getcustometerProductById(id);
	}

}
