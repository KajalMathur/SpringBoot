package com.product.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

// Mongo Database Annotation
@Data
@NoArgsConstructor
@Document
public class Product {
	@Id
	int id;

	@NonNull
	String name;

	@NonNull
	String color;

	@NonNull
	String size;

	@NonNull
	List<String> othersize;

	@NonNull
	Map<String, Integer> Details;

	// Embedded Object
	Manufacturer manufacturer;
}
