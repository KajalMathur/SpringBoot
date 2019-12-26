package com.product.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	public int id;

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
