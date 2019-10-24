package com.product.service;

import java.net.MalformedURLException;

import com.product.model.CustomerProductResponse;

public interface CustomerProductService {

	public CustomerProductResponse getcustometerProductById(int productid , int customerid) throws MalformedURLException;
}
