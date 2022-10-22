package com.incedo.customer.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.incedo.customer.domain.Login;
import com.incedo.customer.service.LoginService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "api/v1/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	RestTemplate restTemplate;

	@PostMapping
	@ResponseBody
	public void login(Login login, HttpSession session, HttpServletResponse response) {

		String status = loginService.login(login);

		if (status.equals("loggedin successfully")) {


			String url = "http://localhost:8087/order/setloginstatus/set?email=" + login.getEmail();
			restTemplate.getForObject(url, String.class);

			String urlforMenuList = "http://localhost:8087/order/loginstatus/confirm?email=" + login.getEmail();
			try {
				response.sendRedirect(response.encodeRedirectURL(urlforMenuList));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			String relogin = "/registration/relogin.html";
			try {
				response.sendRedirect(relogin);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
