package com.incedo.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.incedo.customer.entity.OrderStatusTracker;


@Repository
public interface OrderTrackRepository extends JpaRepository<OrderStatusTracker, Long> {

	Optional<OrderStatusTracker> findByEmail(String email);
}



//@Repository
//public interface LoginStatusRepository extends JpaRepository<LoginStatus, Long> {
//
//	Optional<LoginStatus> findByEmail(String email);
//
//}
