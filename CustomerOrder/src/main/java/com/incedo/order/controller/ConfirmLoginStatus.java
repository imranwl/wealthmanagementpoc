package com.incedo.order.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.incedo.order.service.LoginStatusService;

@Controller
@RequestMapping(path = "/loginstatus")
public class ConfirmLoginStatus {

	@Autowired
	LoginStatusService loginStatusService;

	@GetMapping(path = "/confirm")
	@ResponseBody
	public ModelAndView confirmLogin(@RequestParam(required = false, defaultValue = "empty") String email,
			HttpSession session, HttpServletResponse response) {

		if (!email.equals("empty")) {

			String status = loginStatusService.getLoggedIn(email);
			if (status.equals("present")) {
				session.setAttribute("loggedStatus", "loggedin");
				session.setAttribute("email", email);
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.setViewName("individuals");
				return modelAndView;
			}

		} else {

			String url = "http://localhost:8080/registration/loginfirst.html";
			try {
				response.sendRedirect(url);
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("menu");
		return modelAndView;

	}

}
