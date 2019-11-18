package com.product.service;

import java.net.MalformedURLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.CustomerDao;
import com.product.dao.DefaultProductDao;
import com.product.exception.NotFoundException;
import com.product.model.Customer;
import com.product.model.CustomerProductResponse;
import com.product.model.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerProductServiceImpl implements CustomerProductService {

	private DefaultProductDao defaultProductDao;

	private CustomerDao customerDao;

	@Autowired
	public CustomerProductServiceImpl(DefaultProductDao defaultProductDao, CustomerDao customerDao) {
		this.defaultProductDao = defaultProductDao;
		this.customerDao = customerDao;
	}

	@Override
	public CustomerProductResponse getcustometerProductById(int customerId, int productId) throws MalformedURLException {
		// TODO Auto-generated method stub
		Optional<Product> product = defaultProductDao.findById(productId);
		Customer customer = customerDao.getCustomerResponseById(customerId);
		if (product.isPresent()) {
			CustomerProductResponse customerProductResponse = CustomerProductResponse.builder()
					.customerResponse(customer).product(product.get()).build();
			return customerProductResponse;
		} else
			throw new NotFoundException("Product Not Found , Type : Product , Id =" + productId);

	}

}
