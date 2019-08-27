/*
package com.example.demo.repo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;


@Repository
public class ProductRepo {

	private static Map<String, Product> productRepo1 = new HashMap<>();

	public Collection<Product> productRepoFun() {

		Collection<Product> product = productRepo1.values();
		return product;
	}

	public String productRepoPost(Product product) {

		productRepo1.put(product.getId(), product);
		return "Product is created successfully";
	}

	public String productRepoPut(Product product, String id) {

		productRepo1.remove(id);
		product.setId(id);
		productRepo1.put(id, product);
		productRepo1.put(product.getId(), product);
		return "Product is updated successsfully";
	}

	public String productRepoDelete(String id) {

		productRepo1.remove(id);
		return "Product is deleted successsfully";
	}

}
*/