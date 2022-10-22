package com.incedo.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.incedo.order.service.LoginStatusService;

@Controller
@RequestMapping("/setloginstatus")
public class LoginStatusController {

	@Autowired
	LoginStatusService loginStatusService;

	@GetMapping(path = "/get")
	@ResponseBody
	public void getLoggedIn(@RequestParam String email) {

		String loginStatus = loginStatusService.getLoggedIn(email);

		// return loginStatus;
	}

	@GetMapping(path = "/set")
	@ResponseBody
	public void setLoggedIn(@RequestParam String email) {
		
		String firstCheck = loginStatusService.getLoggedIn(email);

		if(firstCheck.equals("not logged in")) {
		    loginStatusService.setLoggedIn(email);
		
		}

		// return loginStatus;
	}

}
