package com.incedo.customer.email.service;

public interface EmailSender {
	void send(String to, String email);
}