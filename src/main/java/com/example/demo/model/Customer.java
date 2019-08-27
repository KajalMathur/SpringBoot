package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter 
@Setter
@Document
public class Customer {

	
	@Id
	int custid;
	
	
	@NonNull
	 String custName;
	
	 @NonNull 
	 String address;
	 
	/* Customer(String custName , String address){
		 this.custName=custName;
		 this.address=address;
		 
	 }  */
}
