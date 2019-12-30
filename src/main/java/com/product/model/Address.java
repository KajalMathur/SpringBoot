package com.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

	private int addressId;
	String streetName;
	String state;
	String country;
}
