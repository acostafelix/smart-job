package com.cl.smartjob.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cl.smartjob.controller.dto.response.ResponseError;


@RestControllerAdvice
public class SmartJobExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = UserException.class )
    protected ResponseEntity<Object> handleUserException( UserException ex, WebRequest request) {
        
		ResponseError response = new ResponseError(ex.getMessage());
		return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }
	
	@ExceptionHandler(value = ContractInvalidException.class )
    protected ResponseEntity<Object> handleRequestException( ContractInvalidException ex, WebRequest request) {
        
		ResponseError response = new ResponseError(ex.getMessage());
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

}
