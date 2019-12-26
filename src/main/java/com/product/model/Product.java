package com.product.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
