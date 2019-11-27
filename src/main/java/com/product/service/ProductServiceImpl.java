package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.product.dao.ProductDao;
import com.product.exception.InvalidDataException;
import com.product.model.Order;
import com.product.model.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	@Value("${spring.application.id}")
	private String propId;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void createProduct(Product product) {
		productDao.save(product);
	}

	@Override
	public List<Product> getAllProducts(Order order, String containName) {
		if (order==Order.ASC)
			return productDao.findProductByNameLikeOrderByNameAsc(containName);
		else if (order==Order.DESC)
			return productDao.findProductByNameLikeOrderByNameDesc(containName);
		else
			throw new InvalidDataException("Only asc and desc are allowed for contain");
	}

	@Override
	public Optional<Product> findProductById(int id) {
		return productDao.getProductById(id);
	}

	@Override
	public void deleteProductById(int id) {
		productDao.deleteProductById(id);
	}

	@Override
	public void updateProduct(Product product) {
		log.info("We are adding the properties id and user input id");
		int id = product.getId() + Integer.parseInt(propId);
		product.setId(id);
		productDao.save(product);
	}

	@Override
	public void deleteAllProducts() {
		productDao.deleteAllProducts();
	}
}
