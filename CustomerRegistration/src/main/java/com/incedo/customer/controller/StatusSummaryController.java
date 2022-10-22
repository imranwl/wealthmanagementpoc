package com.incedo.customer.controller;

//import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.incedo.customer.entity.Customer;
import com.incedo.customer.service.CustomerService;
import com.incedo.customer.service.OrderTrackService;


@Controller
@RequestMapping(path = "order")
public class StatusSummaryController {
	
	
	@Autowired
	OrderTrackService orderTrackService;
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(path="/summary")
	@GetMapping
	@ResponseBody
	public ModelAndView summary(@RequestParam(value="email") String email,@RequestParam(value = "result") String result) {
		
		
		 
			  
			  
		 orderTrackService.setStatus(email);
		Customer customer=customerService.getCustomer(email);
			  
			  
			  
			  // CompletableFuture.completedFuture(resutls);
			   ModelAndView modelAndView=new ModelAndView();
				  modelAndView.setViewName("report");
				//  String status=orderTrackService.getOrderStatus(email);
				 // modelAndView.addObject("status", status);
				  modelAndView.addObject("fname", customer.getFirstname());
				  modelAndView.addObject("lname",customer.getLastname());
				  modelAndView.addObject("result", result);
				  modelAndView.addObject("email", email);			   
			   return modelAndView;
		 

		
	}

}
