package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import com.example.demo.model.Product;

public interface ProductsService {

	public Collection<Product> getAllProducts();

	public Optional<Product> findEmployeeById(int id);

	public void deleteProductById(int id);

	public void updateProduct(Product emp);

	public void deleteAllProducts();

	Optional<Product> findProductById(int id);

}
