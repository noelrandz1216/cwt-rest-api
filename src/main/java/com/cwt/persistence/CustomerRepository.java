package com.cwt.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cwt.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
