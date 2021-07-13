package com.brane.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brane.springdemo.entity.Customer;
import com.brane.springdemo.service.CustomerService;

//THIS IS CONTROLLER LAYER
@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	//private field customerService, so we can do dependency injection on this field
	//to delegate calls from CONTROLLER LAYER TO THE SERVICE LAYER
	@Autowired
	private CustomerService customerService;
	
		//****************************************************************************************************************
		//WE WILL USING POSTMAN REST CLIENT TO SHOW ALL RESULTS FROM THE HTTP REQUEST METHODS.
		//WE ADDED DEPENDENCY IN POM FILE FOR JACKSON , SO WHEN WE RUN OUR APP
		//AND ENTER THIS ENDPOINT /api/employees (GET) WI WILL HAVE RESPONSE OBJECTS FROM THE DATABASE IN .JSON FORMAT.
		//THAT DATA WE CAN SHOW IN BROWSER OR SOME OTHER REST CLIENT LIKE POSTMAN.
		//WHEN WE GET JAVA OBJECTS FROM THE DATABASE, SPRING BOOT HERE CALLS JACKSON TO CONVERT JAVA POJO IN .JSON FORMAT.
		//WHEN WE CONVERT JAVA POJO TO JSON--->JACKSON CALLS GETTER METHODS
		//WHEN WE CONVERT JSON TO JAVA POJO--->JACKSON CALLS SETTER METHODS
		//*****************************************************************************************************************
		
		
		//add mapping for GET /customers
		@GetMapping("/customers")
		public List<Customer> getCustomers(){
			
			//delegate calls from the CONTROLLER LAYER to the SERVICE LAYER
			return customerService.getCustomers();
			
		}
		
		
		// add mapping for GET /customers/{customerId}
		@GetMapping("/customers/{customerId}")
		public Customer getCustomer(@PathVariable int customerId) {
			
			Customer customer = customerService.getCustomer(customerId);
			
			return customer;
		}
		
		

}
