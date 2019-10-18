package com.example.demo.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;



// Mongo Database Annotation
@Data
@NoArgsConstructor
@Document
public class Product {
	@org.springframework.data.annotation.Id
	int id;

	@NonNull
	String name;

	@NonNull
	String color;

	@NonNull
	String size;

	@NonNull
	@JsonProperty("othersize")
	List<String> othersize;

	@NonNull
	Map<String, Integer> Details;

	// Embedded Object
	Manufacturer manufacturer;

}
