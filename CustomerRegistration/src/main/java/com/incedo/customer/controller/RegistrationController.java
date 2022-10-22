package com.incedo.customer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.incedo.customer.domain.RegistrationRequest;
import com.incedo.customer.service.RegistrationService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping
    @ResponseBody

	public ModelAndView register(RegistrationRequest registrationRequest, HttpSession httpSession) {

		httpSession.setAttribute("registrationRequest", registrationRequest);
		String activation= registrationService.register(registrationRequest);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("activation");
		modelAndView.addObject("activation", activation);
		
		return modelAndView;

	}

	@GetMapping(path = "confirm")
	@ResponseBody
	public ModelAndView confirm(HttpSession httpSession) {

		RegistrationRequest registrationRequest = (RegistrationRequest) httpSession
				.getAttribute("registrationRequest");

		String confirmation= registrationService.confirmToken(registrationRequest);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("confirmation");
		modelAndView.addObject("confirmation", confirmation);
		
		return modelAndView;
		
	}

}