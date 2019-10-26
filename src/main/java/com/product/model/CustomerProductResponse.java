package com.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor


@JsonPropertyOrder({ "customer", "product" })
public class CustomerProductResponse {

	@JsonProperty("customer")
	Customer customerResponse;
	Product product;
}
