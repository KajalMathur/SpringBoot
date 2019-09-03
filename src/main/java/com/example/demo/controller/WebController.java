package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductServiceimpl;

@RestController
public class WebController {

	@Autowired
	// private ProductService // for the cache implementation
	ProductServiceimpl ps;

	@Autowired

	// Tutorial Point
	// get
	@RequestMapping(value = "/products")

	public ResponseEntity<Object> getProduct() {

		return new ResponseEntity<>(ps.getAllProducts(), HttpStatus.OK);
	}

	// POST

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		ps.createProduct(product);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	// PUT
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public String updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
		ps.updateProduct(product);
		return "Product is updated successfully";
		// return new ResponseEntity<>(ps.productServicePut(product, id),
		// HttpStatus.OK);
	}

	// delete
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") int id) {

		ps.deleteProductById(id);
		return new ResponseEntity<>("Product is Deleted successfully", HttpStatus.OK);
		// return new ResponseEntity<>(ps.productServiceDelete(id), HttpStatus.OK);
	}
}