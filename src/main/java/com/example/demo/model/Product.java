 package com.example.demo.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter

// Mongo Database Annotation
@Document(collection= "product")
public class Product {
	
	@NonNull
	@org.springframework.data.annotation.Id
	int id;
	
	@NonNull
	String name;
	
	@NonNull
	String color ;
	
	@NonNull
	String size;
	
	@NonNull
	@JsonProperty("papappa")
	List <String> othersize;
	
	
	

	@NonNull
	Map<String , String> test;

	@NonNull
	Map<String , String> demo ;
	
	@DBRef @JsonProperty("cus")
	Customer cus;
	
	/* Product(int id , String name , String color , String size , List<String> othersize , Map<String , String> test , Map<String,String> demo , Customer cus)
	{
	 this.id=id ;
	 this.name=name ;
	 this.color=color;
	 this.size=size ;
	 this.othersize = othersize ; 
	 this.test=test ; 
	 this.demo=demo;
	 this.cus=cus;
	}  */
	
	
	
}

