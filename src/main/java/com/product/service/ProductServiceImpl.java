package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.product.dao.ProductDao;
import com.product.model.Product;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Value("${spring.application.id}")
	private String propId;

	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;

	}
	public void createProduct(Product product) {
		productDao.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Optional<Product> findProductById(int id) {
		return productDao.findById(id);
	}

	@Override
	public void deleteProductById(int id) {
		productDao.deleteById(id);
	}

	@Override
	public void updateProduct(Product product) {
		log.info("We are adding the properties id and user input id");
		int id = product.getId() + Integer.parseInt(getPropId());
		product.setId(id);
		productDao.save(product);
	}

	@Override
	public void deleteAllProducts() {
		// TODO Auto-generated method stub
		productDao.deleteAll();
	}
}
