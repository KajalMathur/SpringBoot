package com.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/products")
	public List<Product> getProduct(@RequestParam(name = "order") String order,@RequestParam(name = "containName") String containName) {
		return productService.getAllProducts(order, containName);
	}

	@PostMapping("/products")
	public ResponseEntity<String> createProduct(@Valid @RequestBody Product product) {
		productService.createProduct(product);
		return ResponseEntity.ok().body("Product is created successfully");
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
		productService.updateProduct(product);
		return ResponseEntity.ok().body("Product is updated successfully");
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		productService.deleteProductById(id);
		return ResponseEntity.ok().body("Product is Deleted successfully");
	}
}