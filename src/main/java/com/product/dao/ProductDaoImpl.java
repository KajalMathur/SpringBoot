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

	private DefaultProductDao defaultProductDao;

	private RestTemplate restTemplate;

	@Autowired
	public ProductDaoImpl(DefaultProductDao defaultProductDao, RestTemplate restTemplate) {
		this.defaultProductDao = defaultProductDao;
		this.restTemplate = restTemplate;
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		defaultProductDao.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return defaultProductDao.findAll();
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		defaultProductDao.deleteById(id);

	}

	@Override
	public void deleteAllProducts() {
		// TODO Auto-generated method stub
		defaultProductDao.deleteAll();
	}

	@Override
	public Optional<Product> getProductById(int id) {
		// TODO Auto-generated method stub
		Optional<Product> product = defaultProductDao.findById(id);
		return product;
	}

	public Customer getCustomerResponse() {
		return restTemplate.getForObject("http://localhost:8080/api/customers/1", Customer.class);
	}
}
