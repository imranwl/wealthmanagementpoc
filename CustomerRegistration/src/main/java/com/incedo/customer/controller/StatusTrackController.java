package com.incedo.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.incedo.customer.service.CustomerService;
import com.incedo.customer.service.OrderTrackService;

@RequestMapping(path = "order")
@Controller
public class StatusTrackController {
	

	@Autowired
	OrderTrackService orderTrackService;
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(path="/track")
	@GetMapping
	@ResponseBody
	public ModelAndView summary(@RequestParam(value="email") String email) {
		
		
		 
			  
		String status=orderTrackService.getOrderStatus(email);
		
			  
			  
			   ModelAndView modelAndView=new ModelAndView();
				  modelAndView.setViewName("trace");
				  modelAndView.addObject("status", status);
				  
			   
			   return modelAndView;
		 

		
	}
	
	@RequestMapping(path="/gettrack",produces="text/plain")
	@GetMapping
	@ResponseBody()
	public String trackTheStatus(@RequestParam(value="email") String email) {
		
		
		 
			  
		String status=orderTrackService.getOrderStatus(email);
		
			  
			 
				  
			   
			   return status;
		 

		
	}

}
