package com.product.service;

import java.net.MalformedURLException;

import com.product.model.CustomerProductResponse;

public interface CustomerProductService {

	public CustomerProductResponse getcustometerProductById(int customerId, int productId) throws MalformedURLException;
}
