package com.product.model;

import java.util.Date;

import lombok.Data;

@Data
public class Customer {

	public int id;

	private String firstName;

	private String lastName;

	private Date joiningDate;

	private Date expiryDate;

	private Address address;

	private Status status;

	private String userName;

	private String password;

	public enum Status {
		NEW, EXPERIENCED, EXPIRED, INVALID;
	}

}
