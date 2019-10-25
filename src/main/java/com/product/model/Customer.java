package com.product.model;

import java.util.Date;

import lombok.Data;

@Data
public class Customer {

	public int custId;

	private String firstName;

	private String lastName;

	private Date joiningDate;

	private Date expiryDate;

	private Address address;

	private Status status;

	public enum Status {
		NEW, EXPERIENCED, EXPIRED, INVALID;
	}

}
