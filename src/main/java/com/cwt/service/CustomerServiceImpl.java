  package com.cwt.service;

  import java.util.List; import java.util.Optional;
  
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;
  
  import com.cwt.entities.Customer;
  import com.cwt.persistence.CustomerRepository;
  
  import lombok.extern.slf4j.Slf4j;
  
  
  @Service
  @Slf4j 
  public class CustomerServiceImpl implements CustomerService {
  
	  @Autowired
	  private CustomerRepository customerRepository;
	  
	  private String exmsg = "No customer found with Customer ID: ";
	  
	  @Override
	  public Customer findCustomerById(Integer custId) {
	  
		  log.info("From inside the findCustomerById");
		  Customer customer = null;
		  Optional<Customer> optionalCustomer = customerRepository.findById(custId);
	  
		  if(optionalCustomer.isPresent())
			  customer = optionalCustomer.get();
		  else 
			  throw new RuntimeException( exmsg + custId);
		   	  
		  return customer;
	  }
  
	  @Override
	  public List<Customer> findAllCustomers() {
		  return customerRepository.findAll();
	  }
	  
	  @Override
	  public Customer createCustomerRecord(Customer customer) {
		  return customerRepository.save(customer);
	  }
  
	  @Override
	  public void deleteCustomerRecord(Integer custId) {
		  Customer customer = null;
	  	  Optional<Customer> optionalCustomer = customerRepository.findById(custId);
		  
		  if(optionalCustomer.isPresent())
			  customer = optionalCustomer.get();
		  else
			  throw new RuntimeException(exmsg + custId);
		  
		  customerRepository.delete(customer);
	  
	  }
  
	  @Override
	  public Customer updateCustomerRecord(Integer custId, Customer newCustomer) { 
		  log.info("From inside the updateCustomerRecord");
		  Customer customer = null;
		  Customer updatedCustomer = null;
		  Optional<Customer> optionalCustomer = customerRepository.findById(custId);
	  
		  if(optionalCustomer.isPresent()) {
			  customer = optionalCustomer.get();
			  customer.setCustId(newCustomer.getCustId());
			  customer.setFirstName(newCustomer.getFirstName());
			  customer.setLastName(newCustomer.getLastName());
			  customer.setEmail(newCustomer.getEmail());
			  customer.setLocation(newCustomer.getLocation()); updatedCustomer = customerRepository.save(customer);
			  }
		  else
				  throw new RuntimeException(exmsg + custId);
		  
		  return updatedCustomer;
	  }
  
	  @Override
	  public Customer updateEmailRecord(Integer custId, Customer newCustomer) {
	  
		  log.info("From inside the updateCustomerRecord");
		  Customer customer = null;
		  Customer updatedCustomer = null;
		  
		  Optional<Customer> optionalCustomer = customerRepository.findById(custId);
		  
		  if(optionalCustomer.isPresent()) {
			  customer = optionalCustomer.get();
			  customer.setEmail(newCustomer.getEmail());
			  updatedCustomer = customerRepository.save(customer); }
		  else
			  throw new RuntimeException(exmsg + custId);
	  
		  return updatedCustomer;
	  }
  
  }
  
 
