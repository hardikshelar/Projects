package com.idbiintech.iDMS_login.dto;




import org.springframework.data.annotation.Id;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@jakarta.persistence.Entity
@NoArgsConstructor
@Getter
@Setter
public class Employee {
	@jakarta.persistence.Id
	private int empId;
	private String password;
	private String Designation;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Employee(int empId, String password, String designation) {
		super();
		this.empId = empId;
		this.password = password;
		Designation = designation;
	}
	
	
}
