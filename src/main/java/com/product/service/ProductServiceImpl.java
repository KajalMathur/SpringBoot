package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.product.dao.ProductDaoImpl;
import com.product.model.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {


	private ProductDaoImpl productDaoImpl;

	@Value("${spring.application.id}")
	private String propId;

	@Autowired
	public ProductServiceImpl(ProductDaoImpl productDaoImpl) {
		this.productDaoImpl = productDaoImpl;
	}

	@Override
	public void createProduct(Product product) {
		productDaoImpl.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDaoImpl.getAllProducts();
	}

	@Override
	public Optional<Product> findProductById(int id) {
		return productDaoImpl.getProductById(id);
	}

	@Override
	public void deleteProductById(int id) {
		productDaoImpl.deleteProductById(id);
	}

	@Override
	public void updateProduct(Product product) {
		log.info("We are adding the properties id and user input id");
		int id = product.getId() + Integer.parseInt(propId);
		product.setId(id);
		productDaoImpl.save(product);
	}

	@Override
	public void deleteAllProducts() {
		// TODO Auto-generated method stub
		productDaoImpl.deleteAllProducts();
	}
}
