 package com.incedo.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.incedo.customer.entity.Customer;
import com.incedo.customer.entity.OrderStatusTracker;
import com.incedo.customer.repository.OrderTrackRepository;




@Service
public class OrderTrackService {
	
	@Autowired
	OrderTrackRepository orderTrackRepository;
	
	@Autowired
	
	CustomerService customerService;
	
	//@Async
	public void saveOrderStatus(OrderStatusTracker orderStatusTracker ) {
		
		orderTrackRepository.save(orderStatusTracker);
	}
	
	public String getOrderStatus(String email) {
		
		Optional<OrderStatusTracker> optionalRef=orderTrackRepository.findByEmail(email);
		
		if(optionalRef.isPresent()) {
			return optionalRef.get().getOrderStatus();
		}
		else {
			return "Customer not available";
		}
		
	}
	
	@Async
	public  String setStatus(String email) {
		 		  
		  OrderStatusTracker orderStatusTracker=new OrderStatusTracker();
		  
		  orderStatusTracker.setEmail(email);
		  orderStatusTracker.setOrderStatus("Advice Request recieved"); 
		  Customer customer=customerService.getCustomer(email);
		  orderStatusTracker.setCustomer(customer);
		 
		  
		  saveOrderStatus(orderStatusTracker);
		  
		  try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		  
		  orderStatusTracker.setOrderStatus("KYC verification"); 
		  saveOrderStatus(orderStatusTracker);
		  
		  try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		  
		  
		  
		  orderStatusTracker.setOrderStatus("In process"); 
		  saveOrderStatus(orderStatusTracker);
		  
		  try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		  
		  orderStatusTracker.setOrderStatus("Succesfully completed"); 
		  saveOrderStatus(orderStatusTracker);
		  
		  return "all_done";
	}

}
