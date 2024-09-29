package com.idbiintech.iDMS_login.userService;

import org.springframework.stereotype.Service;

import com.idbiintech.iDMS_login.dto.Employee;

@Service
public interface EmployeeService  {
	
	public Employee getEmployeeById(int id);
}
