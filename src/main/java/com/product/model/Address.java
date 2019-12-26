package com.product.model;

import java.util.List;
import java.util.Map;

import com.product.model.Product.ProductBuilder;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Address {

	private int addressId;
	String streetName;
	String state;
	String country;
}
