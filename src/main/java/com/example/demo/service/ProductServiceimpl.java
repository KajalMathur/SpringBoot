package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Productdao;
import com.example.demo.model.Product;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Service
public class ProductServiceimpl implements ProductsService {

	@Autowired
	Productdao productdao;
	@Value("${spring.application.name}")
	private String name;

	@Value("${spring.application.id}")
	private String propId;

	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		Integer id;
		log.info("We are adding the properties id and user input id");
		id = product.getId() + Integer.parseInt(getPropId());
		product.setId(id);
		productdao.save(product);

	}

	@Override
	public Collection<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productdao.findAll();
	}

	@Override
	public Optional<Product> findProductById(int id) {
		// TODO Auto-generated method stub
		return productdao.findById(id);
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		productdao.deleteById(id);

	}

	@Override
	public void updateProduct(Product emp) {
		// TODO Auto-generated method stub
		productdao.save(emp);

	}

	@Override
	public void deleteAllProducts() {
		// TODO Auto-generated method stub
		productdao.deleteAll();

	}

	@Override
	public Optional<Product> findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return productdao.findById(id);
	}
}
