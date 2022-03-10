package com.cwt.service;

import java.util.List;

import com.cwt.entities.Customer;

public interface CustomerService {
	
	public Customer findCustomerById(Integer custId);
	
	public List<Customer> findAllCustomers();
	
	public Customer createCustomerRecord(Customer customer);
	
	public void deleteCustomerRecord(Integer custId);
	
	public Customer updateCustomerRecord(Integer custId, Customer newCustomer);
	
	public Customer updateEmailRecord(Integer custId, Customer newCustomer);

}
