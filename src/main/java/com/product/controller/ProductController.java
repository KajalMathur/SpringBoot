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
import com.product.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/products/{order}/{like}")
	public List<Product> getProduct(@PathVariable String order, @PathVariable String like) {
		return productService.getAllProducts(order, like);
	}

	@PostMapping("/products")
	public ResponseEntity<String> createProduct(@Valid @RequestBody Product product) {
		productService.createProduct(product);
		return new ResponseEntity<String>("Product is created successfully", HttpStatus.OK);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
		productService.updateProduct(product);
		return new ResponseEntity<String>("Product is updated successfully", HttpStatus.OK);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		productService.deleteProductById(id);
		return new ResponseEntity<String>("Product is Deleted successfully", HttpStatus.OK);
	}
}