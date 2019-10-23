package com.product.customerproductservice;

import java.net.MalformedURLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.customerdao.CustomerDao;
import com.product.dao.DefaultProductDao;
import com.product.model.CustomerProductResponse;
import com.product.model.CustomerResponse;
import com.product.model.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerProductServiceImpl implements CustomerProductService {
	
	 private DefaultProductDao defaultProductDao;
	 private CustomerDao customerDao ;
	 
	 @Autowired
	 public CustomerProductServiceImpl(DefaultProductDao defaultProductDao , CustomerDao customerDao ) {
		this.defaultProductDao = defaultProductDao;
		this.customerDao = customerDao;
	}
	
	@Override
	public CustomerProductResponse getcustometerProductById(int id) throws MalformedURLException {
		// TODO Auto-generated method stub
		Optional<Product> product = defaultProductDao.findById(id);
		
		log.info(customerDao.getCustomerResponseById(id).toString());
		 CustomerResponse customerResponse = customerDao.getCustomerResponseById(id).getBody();
		  
		 CustomerProductResponse customerProductResponse = CustomerProductResponse.builder()
				 .product(product.get())
				 .customerResponse(customerResponse)
				 .build();
				 
		return customerProductResponse;
	}


}
