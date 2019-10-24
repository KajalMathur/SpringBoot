package com.product.dao;

import java.net.MalformedURLException;

import org.springframework.http.ResponseEntity;

import com.product.model.CustomerResponse;

public interface CustomerDao {

	public ResponseEntity<CustomerResponse> getCustomerResponseById(int id) throws MalformedURLException;

}
