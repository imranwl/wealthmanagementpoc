package com.incedo.order.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/confirmorder")
public class ConfirmOrderController {

	@PostMapping
	@ResponseBody
	public ModelAndView confirmOrder(@RequestParam(value = "checkboxname") String[] itemNames, HttpSession session,
			HttpServletResponse response) {

		
		if (session.getAttribute("loggedStatus") != null) {

			String email =(String)(session.getAttribute("email"));

			String result = "";
			//int total=0;
			for (int count = 0; count < itemNames.length; count++) {

				if(count==(itemNames.length-1)) {
					result += itemNames[count];
					//total +=PriceList.valueOf(itemNames[count]).getValue();
				}
				else{
					result += itemNames[count] + ", ";
					//total +=PriceList.valueOf(itemNames[count]).getValue();
				}

			}

			//return "Order confirmed for :" + result;
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("confirm");
			modelAndView.addObject("result", result);
			modelAndView.addObject("email", email);
			return modelAndView; 

		}

		else {

			String url = "http://localhost:8080/registration/loginfirst.html";
			try {
				response.sendRedirect(url);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return new ModelAndView();
	}

}








/*
 * package com.incedo.order.controller;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * import com.incedo.order.utility.PriceList;
 * 
 * @RestController
 * 
 * @RequestMapping("/confirmorder") public class ConfirmOrderController {
 * 
 * @GetMapping // public String confirmOrder(@RequestParam(value =
 * "checkboxname") String[] itemNames, HttpSession session, //
 * HttpServletResponse response) { public ModelAndView
 * confirmOrder(@RequestParam(value = "checkboxname") String[] itemNames,
 * HttpSession session, HttpServletResponse response) {
 * 
 * 
 * if (session.getAttribute("loggedStatus") != null) {
 * 
 * String email =(String)(session.getAttribute("email"));
 * 
 * String result = ""; int total=0; for (int count = 0; count <
 * itemNames.length; count++) {
 * 
 * if(count==(itemNames.length-1)) { result += itemNames[count]; total
 * +=PriceList.valueOf(itemNames[count]).getValue(); } else{ result +=
 * itemNames[count] + ", "; total
 * +=PriceList.valueOf(itemNames[count]).getValue(); }
 * 
 * }
 * 
 * //return "Order confirmed for :" + result; ModelAndView modelAndView = new
 * ModelAndView(); modelAndView.setViewName("confirm");
 * modelAndView.addObject("result", result);
 * modelAndView.addObject("total",total); modelAndView.addObject("email",
 * email); return modelAndView;
 * 
 * }
 * 
 * else {
 * 
 * String url = "http://localhost:8080/registration/loginfirst.html"; try {
 * response.sendRedirect(url); } catch (IOException e) { e.printStackTrace(); }
 * 
 * }
 * 
 * return new ModelAndView(); }
 * 
 * }
 */