package edu.jsp.__response_structure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.__response_structure.dto.Student;
import edu.jsp.__response_structure.responce_structure.ResponseStructure;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentRepo stu_repo;
	@PostMapping("/save")
	public ResponseStructure<Student> saveStudent(@RequestBody Student student){
		stu_repo.save(student);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		structure.setCode(HttpStatus.OK.value());
		structure.setMessage("Student saved Successfully!");
		structure.setBody(student);
		return structure;
	}
}
