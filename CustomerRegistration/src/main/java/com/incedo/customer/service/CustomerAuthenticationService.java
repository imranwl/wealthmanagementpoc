package com.incedo.customer.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//import com.incedo.customer.entity.ConfirmationToken;
import com.incedo.customer.entity.Customer;
import com.incedo.customer.repository.CustomerRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Service
@AllArgsConstructor
@Getter
@Setter
public class CustomerAuthenticationService  {

	private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

//	@Autowired
//	private ConfirmationTokenService confirmationTokenService;

//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		return customerRepository.findByEmail(email)
//				.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
//	}

	public String signUpUser(Customer customer) {
		boolean userExists = customerRepository.findByEmail(customer.getEmail()).isPresent();

		if (userExists) {

			return "email already taken";
			// throw new IllegalStateException("email already taken");
		}

		String encodedPassword = bCryptPasswordEncoder.encode(customer.getPassword());

		customer.setPassword(encodedPassword);

		customerRepository.save(customer);

//		String token = UUID.randomUUID().toString();
//
//		ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
//				LocalDateTime.now().plusMinutes(15), customer);
//
//		confirmationTokenService.saveConfirmationToken(confirmationToken);

//        TODO: SEND EMAIL

		return "completed";
	}

//	public int enableAppUser(String email) {
//		return customerRepository.enableAppUser(email);
//	}
}