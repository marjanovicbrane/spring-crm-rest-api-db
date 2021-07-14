package com.brane.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//4.GLOBAL EXCEPTION HANDER
//We will add here annotation @ControllerAdvice, because when we have more REST services,
//then we need to add this 2 exception handler in every RestController class.
//@ControllerAdvice allows us to handle exceptions across the whole application.
//To avoid it, we need to use this annotation and then we can put all exception handlers into one class (one global location).
//@ControllerAdvice is like interceptor of exceptions thrown by methods.
//On that way we have GLOBAL EXCEPTION HANDLER.
@ControllerAdvice
public class CustomerRestExceptionHandler {

	
	//THIS EXCEPTION HANDLER CAN TO HANDLE OR CATCH ONLY THIS EXCEPTION CustomerNotFoundException
	//RESPONSE ENTITY IS WRAPPER CLASS FOR CustomerErrorResponse OBJECT
	//RESPONSE TYPE IS TYPE OF THE RESPONSE BODY-CustomerErrorResponse
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc) {
		
		//WE ARE GOING TO SET ERROR OBJECT WITH CONSTRUCTOR
		CustomerErrorResponse error = new CustomerErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		//NOW WE NEED TO RETURN ResponseEntity OBJECT
		//ERROR IS BODY OF THE RESPONSE, AND HttpStatus.NOT_FOUND IS STATUS CODE FOR THIS RESPONSE
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
		//JACKSON WILL TAKE THIS JAVA POJO AND CONVERT IT TO JSON AND SHOW US IN OUR REST CLIENT
		//OUR CUSTOM ERROR MESSAGE
	}
	
	
	
	
}
