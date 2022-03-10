package com.cwt.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cwt.entities.Customer;
import com.cwt.service.CustomerService;
import com.cwt.service.ValidatorService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ValidatorService validatorService;
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Integer id, HttpServletResponse response) {
		
		Customer customer = customerService.findCustomerById(id);

		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@GetMapping("/all")
	public List<Customer>getCustomers(){
		return customerService.findAllCustomers();
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@Valid @RequestBody Customer customer, BindingResult bindingResult) {
		Map<String, String> validationMap = validatorService.validate(bindingResult);
		if(validationMap.isEmpty()) {
			customerService.createCustomerRecord(customer);
			return new ResponseEntity<>(customer, HttpStatus.CREATED);}
		else
			return new ResponseEntity<>(validationMap, HttpStatus.BAD_REQUEST);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer customerDetails, BindingResult bindingResult){
		Map<String, String> validationMap = validatorService.validate(bindingResult);
		if(validationMap.isEmpty()) {
			Customer updatedCustomer = customerService.updateCustomerRecord(id, customerDetails);
			return new ResponseEntity<>(updatedCustomer, HttpStatus.ACCEPTED);}
		else
			return new ResponseEntity<>(validationMap, HttpStatus.BAD_REQUEST);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteCustomer(@PathVariable Integer id) {
		
		customerService.deleteCustomerRecord(id);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PatchMapping("/partialUpdate/{id}")
	public ResponseEntity<?> updateEmailPartially(@PathVariable Integer id, @Valid @RequestBody Customer customerDetails, BindingResult bindingResult)
	{
		Map<String, String> validationMap = validatorService.validate(bindingResult);
		if(validationMap.isEmpty()) {
			Customer updatedCustomer = customerService.updateEmailRecord(id, customerDetails);
			return new ResponseEntity<>(updatedCustomer, HttpStatus.ACCEPTED);}
		else
			return new ResponseEntity<>(validationMap, HttpStatus.BAD_REQUEST);
	}
		
}