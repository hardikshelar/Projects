package com.idbiintech.iDMS_login.EmployeeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.iDMS_login.dto.Employee;
import com.idbiintech.iDMS_login.repository.EmployeeRepo;
import com.idbiintech.iDMS_login.userService.EmployeeService;

@Service
public class EmpService implements EmployeeService {
	
	@Autowired
	public EmployeeRepo employeeRepo;

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = employeeRepo.findById(id).orElse(null);
		return employee;
		

	}

}
