package com.product.customerdao;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.product.customerproductexception.CustomerProductException;
import com.product.model.CustomerResponse;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private RestTemplate restTemplate;
	
	@Autowired
	CustomerDaoImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	

	@Override
	public ResponseEntity<CustomerResponse> getCustomerResponseById(int id) throws MalformedURLException {
		try
		{
			ResponseEntity<CustomerResponse> response = restTemplate.getForEntity("http://localhost:8080/api/customers/"+id, CustomerResponse.class);
		return response;
		}
		
	   catch(Exception e)
		{
		   throw new CustomerProductException("Not exist , Type : Customer , id="+id);
		}
	}

}
