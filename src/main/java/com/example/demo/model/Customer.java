package com.example.demo.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public class Customer {

	@Getter @Setter @NonNull
	 String custName;
	
	@Getter @Setter @NonNull 
	 String address;
}
