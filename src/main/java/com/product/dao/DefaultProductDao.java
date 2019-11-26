package com.product.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.product.model.Product;

public interface DefaultProductDao extends MongoRepository<Product, Integer> {

	List<Product> findByNameLikeOrderByNameAsc(String containName);

	List<Product> findByNameLikeOrderByNameDesc(String containName);
}
