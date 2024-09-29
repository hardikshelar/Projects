package com.idbiintech.iDMS_login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idbiintech.iDMS_login.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	
}
