package com.ecom.Ecommerce_Website.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.Ecommerce_Website.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByIsActiveTrue();

	List<Product> findByCategory(String category);
	
}
