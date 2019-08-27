/* package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo pr;
	
	 
	 
	 public Collection<Product> productServiceFun()
	{
		
		return pr.productRepoFun();
		
	}

	public String productServicePost(Product product)
	{
		
		return pr.productRepoPost(product);
	}
	
	public String productServicePut(Product product , String id)
	{
		
		return pr.productRepoPut(product , id);
	} 
	
	public String productServiceDelete(String id)
	{
		
		return pr.productRepoDelete(id);
	} 
	

}  */
