package com.incedo.customer.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.incedo.customer.domain.Login;
import com.incedo.customer.entity.Customer;
import com.incedo.customer.repository.CustomerRepository;

@Service
public class LoginService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public String login(Login login) {

		System.out.println("inside login service -- entered");

		Optional<Customer> customer = customerRepository.findByEmail(login.getEmail());

		if (customer.isPresent()) {

			System.out.println("inside login service -- email verified ");

			Customer customerDomain = customer.get();

			boolean passwordMatch = bCryptPasswordEncoder.matches(login.getPassword(), customerDomain.getPassword());

			if (passwordMatch) {
				System.out.println("inside login service -- password correct");

				return "loggedin successfully";
			} else {
				System.out.println("inside login service -- Incorrect password");

				return "Invalid password";
			}

		}

		else {

			System.out.println("inside login service -- customer cannot be traced");

			return "Not a registered customer";
		}

	}

}
