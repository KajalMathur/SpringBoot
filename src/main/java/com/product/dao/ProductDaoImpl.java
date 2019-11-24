package com.product.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.product.model.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductDaoImpl implements ProductDao {

	private DefaultProductDao defaultProductDao;

	@Value("${spring.application.id}")
	private String propId;

	@Autowired
	public ProductDaoImpl(DefaultProductDao defaultProductDao) {
		this.defaultProductDao = defaultProductDao;
	}

	@Override
	public void save(Product product) {
		defaultProductDao.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return defaultProductDao.findAll();
	}

	@Override
	public void deleteProductById(int id) {
		defaultProductDao.deleteById(id);

	}

	@Override
	public void deleteAllProducts() {
		defaultProductDao.deleteAll();
	}

	@Override
	public Optional<Product> getProductById(int id) {
		Optional<Product> product = defaultProductDao.findById(id);
		return product;
	}

	@Override
	public List<Product> findProductByNameLikeOrderByNameAsc(String like) {
		return defaultProductDao.findByNameLikeOrderByNameAsc(like);
	}

	@Override
	public List<Product> findProductByNameLikeOrderByNameDesc(String like) {
		return defaultProductDao.findByNameLikeOrderByNameDesc(like);
	}

}