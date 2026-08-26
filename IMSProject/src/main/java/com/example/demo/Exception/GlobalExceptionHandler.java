package com.example.demo.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ProductNotFoundException.class)
public  ResponseEntity<ErrorMessageDTO> handleProductException(ProductNotFoundException ex)
{
ErrorMessageDTO dto=new ErrorMessageDTO(ex.getMessage(),HttpStatus.NOT_FOUND.value());
return new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);

}
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex){
	Map<String, String> errors = new HashMap<>();

    ex.getBindingResult().getFieldErrors().forEach(error -> {
        errors.put(error.getField(), error.getDefaultMessage());
    });

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	
}
}
