package com.product.service;

import com.product.model.CustomerProductResponse;

public interface CustomerProductService {

	public CustomerProductResponse getcustomerProductById(int customerId, int productId);
}
