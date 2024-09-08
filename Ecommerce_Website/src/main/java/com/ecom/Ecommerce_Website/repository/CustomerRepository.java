package com.ecom.Ecommerce_Website.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.Ecommerce_Website.dto.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Integer> {
	
}
