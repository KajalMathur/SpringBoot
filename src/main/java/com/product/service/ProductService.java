package com.product.service;

import java.util.List;
import java.util.Optional;

import com.product.model.Product;

public interface ProductService {

	public void deleteProductById(int id);

	public void updateProduct(Product emp);

	public void deleteAllProducts();

	Optional<Product> findProductById(int id);

	void createProduct(Product product);

	List<Product> getAllProducts(String order, String like);
}
