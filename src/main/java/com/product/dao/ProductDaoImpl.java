package com.product.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.product.model.Customer;
import com.product.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	private DefaultProductDao productDaoDefault;

	@Autowired
	RestTemplate restTemplate;

	public ProductDaoImpl(DefaultProductDao productDaoDefault) {
		this.productDaoDefault = productDaoDefault;
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		productDaoDefault.save(product);

	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDaoDefault.findAll();
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		productDaoDefault.deleteById(id);

	}

	@Override
	public void deleteAllProducts() {
		// TODO Auto-generated method stub
		productDaoDefault.deleteAll();

	}

	@Override
	public Optional<Product> getProductById(int id) {
		// TODO Auto-generated method stub
		Optional<Product> product = productDaoDefault.findById(id);
		return product;
	}

	public Customer getCustomerResponse() {
		return restTemplate.getForObject("http://localhost:8080/api/customers/1", Customer.class);
	}
}
