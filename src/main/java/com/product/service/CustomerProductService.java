package com.product.service;

import com.product.model.CustomerProductResponse;

public interface CustomerProductService {

	public CustomerProductResponse getcustometerProductById(int customerId, int productId);
}
