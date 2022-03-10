package com.cwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.cwt.controllers.CustomerController;
import com.cwt.entities.Customer;
import com.cwt.exceptions.GlobalExceptionHandler;
import com.cwt.service.CustomerService;
import com.cwt.service.ValidatorService;

@SpringBootTest
class CwtRestApiApplicationTests {

	@Mock
	private Customer customer;
	
	@Mock
	private ValidatorService validatorService;
	
	@Mock
	private BindingResult bindingResult;
	
	@InjectMocks
	private CustomerController customerController;
	
	@Mock
	private CustomerService customerService;
	
	@SuppressWarnings("unchecked")
	@Test
	@DisplayName("Test Post Mapping")
	void testPostMapping() {
		customer.setCustId(1);
		customer.setFirstName("Randy");
		customer.setLastName("Vargas");
		customer.setEmail("randy@gmail.com");
		customer.setLocation("Muntinlupa City");
		
		ResponseEntity<Customer> responseEntity = (ResponseEntity<Customer>) customerController.create(customer, bindingResult);
		
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		
	}
	
	/***
	@SuppressWarnings("unchecked")
	@Test
	@DisplayName("Test Post Mapping Test Exception")
	void testPostMappingTestValidateErrors() {
		customer.setCustId(1);
		customer.setFirstName("Randy");
		customer.setLastName("Vargas");
		customer.setEmail("randygmail.com");
		customer.setLocation("Muntinlupa City");
		
		ResponseEntity<Customer> responseEntity = (ResponseEntity<Customer>) customerController.create(customer, bindingResult);
		
		assertEquals(HttpStatus.CREATED, bindingResult.getAllErrors().stream().filter("First name must not be blank"));
		
	}**/
	
	@Test
	@DisplayName("testGetMapping")
	void testGetMapping() {
		
		customer.setCustId(1);
		customer.setFirstName("Randy");
		customer.setLastName("Vargas");
		customer.setEmail("randy@gmail.com");
		customer.setLocation("Muntinlupa City");
		
		customerController.create(customer, bindingResult);
		
		ResponseEntity<Customer> responseEntity = (ResponseEntity<Customer>) customerController.getCustomer(1, null);
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
	}
	
	
	/***********
	
	@Test
	@DisplayName("testGetMapping")
	void testGetMappingInvalidCustomer() {
		Customer customer = 
		
		Mockito.when(customerController.getCustomer(1, null)).thenReturn(customer);
		
		RuntimeException exception = assertThrows(RuntimeException.class, ()->customerController.getCustomer(1, null));
		
		assertEquals("No customer found with Customer ID: " + Integer.toString(1), exception.getMessage());
		
	}
	*****/

}
