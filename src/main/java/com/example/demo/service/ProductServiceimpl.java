package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Productdao;
import com.example.demo.model.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@Service
public class ProductServiceimpl implements ProductsService {

	@Autowired
	Productdao product;
	@Value("${spring.application.name}")
	private String name;

	@Value("${spring.application.id}")
	private String propId;

	public void createProduct(Product product2) {
		// TODO Auto-generated method stub
		Integer id;
		log.info("We are adding the properties id and user input id");
		id = product2.getId() + Integer.parseInt(getPropId());
		product2.setId(id);
		product.save(product2);

	}

	@Override
	public Collection<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return product.findAll();
	}

	@Override
	public Optional<Product> findProductById(int id) {
		// TODO Auto-generated method stub
		return product.findById(id);
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		product.deleteById(id);

	}

	@Override
	public void updateProduct(Product emp) {
		// TODO Auto-generated method stub
		product.save(emp);

	}

	@Override
	public void deleteAllProducts() {
		// TODO Auto-generated method stub
		product.deleteAll();

	}

	@Override
	public Optional<Product> findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return product.findById(id);
	}

	@Override
	public void createProduct(List<Product> emp) {
		// TODO Auto-generated method stub

	}

}
