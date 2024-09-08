package edu.jsp.__Student_Management_System.exceptionClasses;

public class InvalidEmailOrPasswordException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Invalid Credentials, i.e. Invalid Email Number or Password";
	}
	
}
