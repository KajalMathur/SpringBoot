package com.product.dao;

import java.util.List;
import java.util.Optional;

import com.product.model.Product;

public interface ProductDao {

	public void save(Product product);

	public Optional<Product> getProductById(int id);

	public List<Product> getAllProducts();

	public void deleteProductById(int id);

	public void deleteAllProducts();

	public List<Product> findProductByNameLikeOrderByNameDesc(String contain);

	public List<Product> findProductByNameLikeOrderByNameAsc(String contain);
}
