package edu.jsp.__exception_handling.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.jsp.__exception_handling.reponse_structure.ResponseStructure;
@ControllerAdvice
public class StudentExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ResponseStructure<String>> handleNullPointerxception(NullPointerException nullpointerexception){
		System.out.println("Hii! i am called nullpointerexception");
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setCode(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("Message : "+nullpointerexception.getMessage());
		structure.setBody("Dont deal with Null data..");
		return new ResponseEntity<>(structure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<ResponseStructure<String>> handleArithmaticPointerxception(ArithmeticException arithmeticException){
		System.out.println("Hii! i am called ArithmaticException");
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setCode(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("Message : "+arithmeticException.getMessage());
		structure.setBody("Dont do invalid operation..");
		return new ResponseEntity<>(structure, HttpStatus.BAD_REQUEST);
	}
}
