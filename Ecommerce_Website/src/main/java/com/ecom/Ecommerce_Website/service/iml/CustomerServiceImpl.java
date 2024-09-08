package com.ecom.Ecommerce_Website.service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.Ecommerce_Website.dto.Customers;
import com.ecom.Ecommerce_Website.repository.CustomerRepository;
import com.ecom.Ecommerce_Website.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	public CustomerRepository customerRepo;
	
	@Override
	public Customers saveCustomer(Customers customer) {
		
		return customerRepo.save(customer);
	}
	
}
