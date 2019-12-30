package com.product.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.product.model.Product.ProductBuilder;

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
public class Manufacturer {

	@Id
	int manufactureId;

	@NonNull
	String manufactureName;

	@Range(min = 0l, message = "Please select positive numbers Only")
	int tinNo;
}
