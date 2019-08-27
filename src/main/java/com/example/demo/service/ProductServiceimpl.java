 package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Productdao;
import com.example.demo.model.Product;

@Service
public class ProductServiceimpl implements ProductsService {

	@Autowired
	Productdao product;
	
	@Override
	public void createProduct(Product product2) {
		// TODO Auto-generated method stub		
		product.save(product2);
		
	}

	@Override
	public Collection<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return product.findAll();
	}

	@Override
	public Optional<Product> findProductById(int id) {
		// TODO Auto-generated method stub
		return product.findById(id);
	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		product.deleteById(id);
		
	}

	@Override
	public void updateProduct(Product emp) {
		// TODO Auto-generated method stub
		product.save(emp);
		
	}

	@Override
	public void deleteAllProducts() {
		// TODO Auto-generated method stub
		product.deleteAll();
		
	}

	@Override
	public Optional<Product> findEmployeeById(int id) {
		// TODO Auto-generated method stub
		return  product.findById(id);
	}

	@Override
	public void createProduct(List<Product> emp) {
		// TODO Auto-generated method stub
		
	}
	

}


