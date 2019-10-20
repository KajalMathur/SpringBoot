package com.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.service.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductController {

	private ProductServiceImpl productServiceImpl;

	@Autowired
	public ProductController(ProductServiceImpl productServiceImpl) {
		this.productServiceImpl = productServiceImpl;
	}

	@GetMapping("/products")
	public List<Product> getProduct() {
		return productServiceImpl.getAllProducts();
	}

	@PostMapping("/products")
	public ResponseEntity<String> createProduct(@Valid @RequestBody Product product) {
		productServiceImpl.createProduct(product);
		return new ResponseEntity<String>("Product is created successfully", HttpStatus.OK);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
		productServiceImpl.updateProduct(product);
		return new ResponseEntity<String>("Product is updated successfully", HttpStatus.OK);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		productServiceImpl.deleteProductById(id);
		return new ResponseEntity<String>("Product is Deleted successfully", HttpStatus.OK);
	}

}