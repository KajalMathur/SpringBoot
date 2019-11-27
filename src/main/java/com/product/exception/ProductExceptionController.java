package com.product.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class ProductExceptionController {

	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<Void> exception(NotFoundException exception) {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(value = InvalidDataException.class)
	public ResponseEntity<String> exception(InvalidDataException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
}