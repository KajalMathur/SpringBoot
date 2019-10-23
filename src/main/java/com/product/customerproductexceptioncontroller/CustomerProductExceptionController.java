package com.product.customerproductexceptioncontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.product.customerproductexception.CustomerProductException;



@ControllerAdvice
class CustomerProductExceptionController  {
	
	@ExceptionHandler(value = CustomerProductException.class )
	public ResponseEntity<String> exception(CustomerProductException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}