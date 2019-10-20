package com.product.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.product.model.Customer;
import com.product.model.Product;

@Repository
public interface ProductDao extends MongoRepository<Product, Integer> {
	
	@Autowired
	RestTemplate restTemplate = new RestTemplate();

	public default Customer getCustomerResponse() {
		return restTemplate.getForObject("http://localhost:8080/api/customers/1", Customer.class);
	}
}
