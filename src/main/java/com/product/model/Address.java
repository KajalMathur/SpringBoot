package com.product.model;

import lombok.Data;

@Data
public class Address {

	private int addressId;
	String streetName;
	String state;
	String country;
}
