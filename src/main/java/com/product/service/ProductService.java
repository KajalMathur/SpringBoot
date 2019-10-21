package com.product.service;

import java.util.List;
import java.util.Optional;

import com.product.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public void deleteProductById(int id);

	public void updateProduct(Product emp);

	public void deleteAllProducts();

	Optional<Product> findProductById(int id);

	void createProduct(Product product);
}
