package edu.jsp.__Student_Management_System.exceptionClasses;

public class IdNotFoundException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Invalid Student Id, Student with this Id is Not Present in DAO";
	}
	
}
