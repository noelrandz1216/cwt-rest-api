package com.cwt.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cwt.controllers.CustomerController;
import com.cwt.entities.Customer;
import com.cwt.service.CustomerService;
import com.cwt.service.ValidatorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	private Customer customer;
	
	private List<Customer> customerList = new ArrayList<>();
	
	@MockBean
	private CustomerService customerService;
	
	@MockBean
	private ValidatorService validatorService;
	
	@BeforeEach
	void setUp() throws Exception {
		customer = Customer.builder()
				.firstName("Randy")
				.lastName("Vargas")
				.email("randy@gmail.com")
				.location("Muntinlupa City")
				.build();
		
		customerList.add(customer);
	}
	
	@Test
	void testCreateCustomer() throws Exception {
		Customer inputCustomer = 
				Customer.builder()
				.firstName("Randy")
				.lastName("Vargas")
				.email("randy@gmail.com")
				.location("Muntinlupa City")
				.build();
		
		Mockito.when(customerService
				.createCustomerRecord(inputCustomer))
				.thenReturn(customer);
		
		mockMvc.perform(post("/customers/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(inputCustomer)))
				.andExpect(status().isCreated());	
	}
	
	/***
	@Test
	void testCreateCustomerWithInvalidEntries() throws Exception {
		Customer inputCustomer = 
				Customer.builder()
				.firstName("")
				.lastName("Vargas")
				.email("randygmail.com")
				.location("Muntinlupa City")
				.build();
		
		Mockito.when(customerService
				.createCustomerRecord(inputCustomer))
				.thenThrow();
	}***/
	
	@Test
	void testGetCustomer() throws Exception {
		Integer inputCustId = 1;
		
		Mockito.when(customerService
				.findCustomerById(inputCustId))
				.thenReturn(customer);
		
		mockMvc.perform(get("/customers/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(inputCustId)))
				.andExpect(status().is(200));	
		
	}
	
	@Test
	void testUpdateCustomer() throws Exception {
		Integer inputCustId = 1;
		Customer inputCustomer = 
				Customer.builder()
				.firstName("Victor")
				.lastName("Vargas")
				.email("randygmail.com")
				.location("Muntinlupa City")
				.build();
		
		Customer expectedCustomer = 
				Customer.builder()
				.firstName("Victor")
				.lastName("Vargas")
				.email("randygmail.com")
				.location("Muntinlupa City")
				.build();
		
		Mockito.when(customerService
				.updateCustomerRecord(inputCustId, inputCustomer))
				.thenReturn(expectedCustomer);
		
		mockMvc.perform(put("/customers/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(inputCustomer)))
				.andExpect(status().isAccepted());
	}
	/***
	@Test
	void testGetAllCustomers() throws Exception {
		
	}***/


}
