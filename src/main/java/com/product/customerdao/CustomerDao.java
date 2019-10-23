package com.product.customerdao;

import java.net.MalformedURLException;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import com.product.model.CustomerResponse;

public interface CustomerDao {
	
	public ResponseEntity<CustomerResponse> getCustomerResponseById(int id) throws MalformedURLException;


}
