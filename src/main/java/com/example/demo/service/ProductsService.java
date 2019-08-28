 package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;

public interface ProductsService {
	
	
	public void createProduct(List<Product> emp);

	
	public Collection<Product> getAllProducts();

	
	public Optional<Product> findEmployeeById(int id);

	
	public void deleteProductById(int id);

	
	public void updateProduct(Product emp);

	
	public void deleteAllProducts();

	Optional<Product> findProductById(int id);


	void createProduct(Product product2);

	

}


