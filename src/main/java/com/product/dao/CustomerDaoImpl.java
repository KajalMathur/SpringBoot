package com.product.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.product.exception.NotFoundException;
import com.product.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CustomerDaoImpl implements CustomerDao {

	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancer;

	@Value("${spring.data.zuulservice}")
	private String zuulServiceName;
	
	@Value("${spring.url.customerService}")
	private String customerServicePath;

	@Autowired
	CustomerDaoImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public Customer getCustomerResponseById(int customerId) {
		try {
			ServiceInstance serviceInstance = loadBalancer.choose(zuulServiceName);
			Customer response = restTemplate.getForObject(serviceInstance.getUri().toString() + customerServicePath + customerId , Customer.class);
			return response;
		} catch (Exception e) {
			throw new NotFoundException("Customer Not Found , Type : Customer , id=" + customerId);
		}
	}
}
