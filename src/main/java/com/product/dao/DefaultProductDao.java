package com.product.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.product.model.Product;

public interface DefaultProductDao extends MongoRepository<Product, Integer> {

}
