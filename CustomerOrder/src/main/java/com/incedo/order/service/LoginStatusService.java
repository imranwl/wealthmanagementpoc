package com.incedo.order.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incedo.order.entity.LoginStatus;
import com.incedo.order.repository.LoginStatusRepository;

@Service
public class LoginStatusService {

	@Autowired
	LoginStatusRepository loginStatusRepository;

	public String setLoggedIn(String email) {

		LoginStatus loginStatus = new LoginStatus();

		loginStatus.setEmail(email);
		loginStatus.setLoginStatus(true);

		loginStatusRepository.save(loginStatus);

		return "loginStatus completed";
	}

	public String getLoggedIn(String email) {

		Optional<LoginStatus> loginStatusOptional = loginStatusRepository.findByEmail(email);

		if (loginStatusOptional.isPresent()) {
			return "present";
		}

		else
			return "not logged in";

	}

}
