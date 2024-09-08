package edu.jsp.__Student_Management_System.exceptionClasses;

public class NoStudentsFoundException extends RuntimeException {
	


	@Override
	public String getMessage() {
		return "No Student Are Present in DataBase, Database is Empty...";
	}
	
}
