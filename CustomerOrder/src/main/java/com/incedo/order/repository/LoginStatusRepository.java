package com.incedo.order.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.incedo.order.entity.LoginStatus;

@Repository
public interface LoginStatusRepository extends JpaRepository<LoginStatus, Long> {

	Optional<LoginStatus> findByEmail(String email);

}
