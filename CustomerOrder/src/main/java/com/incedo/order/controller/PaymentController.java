package com.incedo.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController {
	
	@PostMapping("/payment")
	@ResponseBody
	public ModelAndView payment(@RequestParam(value="items") String items,@RequestParam(value="total") int total,
			                    @RequestParam(value="email") String email) {
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("payment");
		modelAndView.addObject("items", items);
		modelAndView.addObject("total", total);
		modelAndView.addObject("email",email);
		
		return modelAndView;
		//return "Payment completed for :"+items+". Total cost is :"+total;
	}
	
	

}
