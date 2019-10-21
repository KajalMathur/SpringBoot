package com.product.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Document
public class Manufacturer {

	@Id
	int manufactureId;

	@NonNull
	String manufactureName;

	@Range(min = 0l, message = "Please select positive numbers Only")
	int tinNo;
}
