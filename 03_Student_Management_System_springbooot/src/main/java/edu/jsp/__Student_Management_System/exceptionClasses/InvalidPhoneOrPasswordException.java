package edu.jsp.__Student_Management_System.exceptionClasses;

public class InvalidPhoneOrPasswordException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Invalid Credentials, i.e. Invalid Phone Number or Password";
	}
	
}
