package com.product.customerproductservice;

import java.net.MalformedURLException;

import com.product.model.CustomerProductResponse;

public interface CustomerProductService {

	public CustomerProductResponse getcustometerProductById(int id) throws MalformedURLException;
}
