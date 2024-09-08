package edu.jsp.__exception_handling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.__exception_handling.dto.Student;
import edu.jsp.__exception_handling.reponse_structure.ResponseStructure;
import edu.jsp.__exception_handling.repository.StudentRepo;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentRepo stu_repo;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student){
		stu_repo.save(student);
		student.setName(student.getName()+" : "+student.getName().length()/0);
		
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		structure.setCode(HttpStatus.OK.value());
		structure.setMessage("Student saved Successfully!");
		structure.setBody(student);
		return new ResponseEntity<>(structure,HttpStatus.OK) ;
	}
}
