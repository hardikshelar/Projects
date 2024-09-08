package edu.jsp.__Student_Management_System.Exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.jsp.__Student_Management_System.exceptionClasses.IdNotFoundException;
import edu.jsp.__Student_Management_System.exceptionClasses.InvalidEmailOrPasswordException;
import edu.jsp.__Student_Management_System.exceptionClasses.InvalidPhoneOrPasswordException;
import edu.jsp.__Student_Management_System.exceptionClasses.NoStudentsFoundException;
import edu.jsp.__Student_Management_System.response_structure.ResponseStructure;

@RestControllerAdvice
public class StudentExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException idnotfoundexception){
		System.out.println("Hii! i am called IdNotFoundxception");
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setCode(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("Message : "+idnotfoundexception.getMessage());
		structure.setBody("Dont deal with invalid data");
		return new ResponseEntity<>(structure, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidEmailOrPasswordException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidEmailOrPasswordException(InvalidEmailOrPasswordException invalidemailOrPasswordException){
		System.out.println("Hii! i am called invalidemailOrPasswordException");
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setCode(HttpStatus.NO_CONTENT.value());
		structure.setMessage("Message : "+invalidemailOrPasswordException.getMessage());
		structure.setBody("Dont deal with invalid data");
		return new ResponseEntity<>(structure, HttpStatus.NO_CONTENT);
	}
	@ExceptionHandler(InvalidPhoneOrPasswordException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidPhoneOrPasswordException(InvalidPhoneOrPasswordException InvalidPhoneOrPasswordException){
		System.out.println("Hii! i am called InvalidPhoneOrPasswordException");
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setCode(HttpStatus.NO_CONTENT.value());
		structure.setMessage("Message : "+InvalidPhoneOrPasswordException.getMessage());
		structure.setBody("Dont deal with invalid data");
		return new ResponseEntity<>(structure, HttpStatus.NO_CONTENT);
	}
	@ExceptionHandler(NoStudentsFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoStudentsFoundException(NoStudentsFoundException NoStudentsFoundException){
		System.out.println("Hii! i am called NoStudentsFoundException");
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setCode(HttpStatus.NO_CONTENT.value());
		structure.setMessage("Message : "+NoStudentsFoundException.getMessage());
		structure.setBody("Dont deal with invalid data");
		return new ResponseEntity<>(structure, HttpStatus.NO_CONTENT);
	}
}
