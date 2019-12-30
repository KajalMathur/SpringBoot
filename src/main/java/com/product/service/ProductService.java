package com.product.service;

import java.util.List;
import java.util.Optional;

import com.product.model.Order;
import com.product.model.Product;

public interface ProductService {

	public void deleteProductbyId(int id);

	public void updateProduct(Product emp);

	public void deleteAllProducts();

	Optional<Product> findProductById(int id);

	void createProduct(Product product);

	public List<Product> getAllProducts(Order order, String containName);
}
