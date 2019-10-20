package com.product.service;

import java.util.Collection;
import java.util.Optional;

import com.product.model.Product;

public interface ProductService {

	public Collection<Product> getAllProducts();

	public void deleteProductById(int id);

	public void updateProduct(Product emp);

	public void deleteAllProducts();

	Optional<Product> findProductById(int id);
}
