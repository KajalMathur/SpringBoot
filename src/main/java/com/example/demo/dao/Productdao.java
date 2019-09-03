package com.example.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
// Dao interface extends the Mongo Repository to handle the curd operations automatically

@Repository
public interface Productdao extends MongoRepository<Product, Integer> {

}
