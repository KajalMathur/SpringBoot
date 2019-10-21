package com.product.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class Customer {

	private int id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	private Date joiningDate;

	private Date expiryDate;

	private Address address;
}
