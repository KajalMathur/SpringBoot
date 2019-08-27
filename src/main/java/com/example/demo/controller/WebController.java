package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.service.ProductServiceimpl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class WebController {
	 @Autowired
	 //private ProductService // for the cache implementation
	 ProductServiceimpl ps;
	
		   
	   
	// Tutorial Point
	   // get
	   @RequestMapping(value = "/products")
	   
	   public ResponseEntity<Object> getProduct() 
	   {
		   log.debug("Inside HTTP get method");
		  return new ResponseEntity<>(ps.getAllProducts(), HttpStatus.OK);
	   }
	   
	   
	   // POST 
	  
	      @RequestMapping(value = "/products", method = RequestMethod.POST)
	      public ResponseEntity<Object> createProduct(@RequestBody Product product , Customer customer) {	
	    	  log.debug("Inside HTTP post method");
	    	  System.out.print("Customer class ====="+product.getCus());
	    		System.out.print("Customer====="+product.getCus() + customer.getAddress() + customer.getCustid() + customer.getCustName());
	    		customer.setCustid(product.getCus().getCustid());
	    		customer.setAddress(product.getCus().getAddress());
	    		customer.setCustName(product.getCus().getCustName());
	    		product.setCus(customer);
	    	  ps.createProduct(product , customer);
	         return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	      }
	      
	      //PUT
	      @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	      public String updateProduct(@PathVariable("id") int id, @RequestBody Product product) { 
	    	  log.debug("Inside HTTP put method");
	    	  ps.updateProduct(product);
	    	  return"Product is updated successfully";
	    	  // return new ResponseEntity<>(ps.productServicePut(product, id), HttpStatus.OK);
	      }   
	      
	      //delete
	      @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	      public ResponseEntity<Object> delete(@PathVariable("id") int id) { 
	    	  log.debug("Inside HTTP delete method");
	    	  ps.deleteProductById(id);
	    	   return  new ResponseEntity<>("Product is Deleted successfully" ,HttpStatus.OK);
	         // return new ResponseEntity<>(ps.productServiceDelete(id), HttpStatus.OK);
	      }
}