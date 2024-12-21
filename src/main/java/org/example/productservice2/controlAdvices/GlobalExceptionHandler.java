package org.example.productservice2.controlAdvices;

import org.example.productservice2.exceptions.ProductNotFoundException;
import org.example.productservice2.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException() {
        return new ResponseEntity<>(
                "Product not found",
                HttpStatus.NOT_FOUND
        );
    }
}
