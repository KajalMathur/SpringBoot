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
	
	
	
	
	Map test;
	Map demo ;
	
	@Autowired @DBRef
	Customer cus;
	
}

