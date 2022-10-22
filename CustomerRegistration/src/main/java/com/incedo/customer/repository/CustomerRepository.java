package com.incedo.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.incedo.customer.entity.Customer;

@Repository
@Transactional(readOnly = true)
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByEmail(String email);

	@Transactional
	@Modifying
	@Query("UPDATE Customer a " + "SET a.enabled = TRUE WHERE a.email = ?1")
	int enableAppUser(String email);

}