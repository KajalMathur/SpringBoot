package com.product.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.product.exception.NotFoundException;
import com.product.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private RestTemplate restTemplate;

	@Value("${spring.data.customerServiceGetUrl}")
	private String customerServiceGetUrl;

	@Autowired
	CustomerDaoImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public Customer getCustomerResponseById(int customerId) {
		try {
			Customer response = restTemplate.getForObject(customerServiceGetUrl + customerId, Customer.class);
			return response;
		} catch (Exception e) {
			throw new NotFoundException("Customer Not Found , Type : Customer , id=" + customerId);
		}
	}

}
