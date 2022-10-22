package com.incedo.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incedo.customer.entity.Customer;
import com.incedo.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer getCustomer(String email) {
	
	    Optional<Customer> customerOptinal = customerRepository.findByEmail(email);
	    
	    Customer customer=null;
	    
	    if (customerOptinal.isPresent()) {

               customer = customerOptinal.get();
	    }
	    
	    return customer;
	}

}
