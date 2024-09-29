package com.idbiintech.iDMS_login.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.idbiintech.iDMS_login.EmployeeServiceImpl.EmpService;
import com.idbiintech.iDMS_login.dto.Employee;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpSession;





@Controller
public class UserController {
	
	@Autowired
	public EmpService employeeService;
	
	
	
	@GetMapping("/user")
	public String userLogin() {
		return "login";
	}
	
	@PostMapping("/loginuser")
	public String CustomerLogin(@RequestParam int id,@RequestParam String password, HttpSession session) {
		Employee employeeById = employeeService.getEmployeeById(id);
		
		if(employeeById==null) {
			session.setAttribute("errorMsg", "Invalid Credentials"); 
			return "login";
		}
		System.out.println(employeeById.getDesignation());
		if(employeeById.getDesignation().equals("MT") && employeeById.getPassword().equals(password) && employeeById.getEmpId()==id ) {
			session.setMaxInactiveInterval(200);
			return "CustomerLogin";
		} else if(employeeById.getDesignation().equals("Manager") && employeeById.getPassword().equals(password) ) {
			session.setMaxInactiveInterval(200);
		return "AdminLogin";
		}
		else {		
			 session.setAttribute("errorMsg", "Invalid Credentials"); 
		}
		return "login";
	}
	

	
}
