package com.incedo.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



import com.incedo.customer.entity.Customer;


@Entity
public class OrderStatusTracker {
	
	
	
	public OrderStatusTracker() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	

	@Column(unique=true)
	private String email;
	
	@Column(columnDefinition="varchar(200) default 'Advice Request recieved'")
	private String orderStatus;
	
	@OneToOne
	@JoinColumn(
			  name="c_id",
			  referencedColumnName ="id"
			)
	
	private Customer customer;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
