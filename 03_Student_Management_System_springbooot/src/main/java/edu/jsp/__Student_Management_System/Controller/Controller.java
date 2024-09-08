package edu.jsp.__Student_Management_System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.__Student_Management_System.Service.StudentService;
import edu.jsp.__Student_Management_System.dto.Student;
import edu.jsp.__Student_Management_System.response_structure.ResponseStructure;

@RestController
public class Controller {
	
	@Autowired
	StudentService service;

	@GetMapping("/hii")
	public String home() {
		return "Hello From Home";
	}

	@PostMapping(value = "/student")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}

	@PutMapping(value = "/student")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}

	@GetMapping(value = "/student/{id}")
	public ResponseEntity<ResponseStructure<Student>> findStudent(@PathVariable int id) {
		return service.findStudentById(id);
	}

	@GetMapping(value = "/student/{phone}/{password}")
	public ResponseEntity<ResponseStructure<Student>> findStudentByPhoneAndPassword(@PathVariable long phone,
			@PathVariable String password) {
		return service.findStudentByPhoneAndPassword(phone, password);
	}

	@GetMapping(value = "/student")
	public ResponseEntity<ResponseStructure<Student>> findStuidentByEmailAndPassword(@RequestParam String email,
			String password) {
		return service.findStudentByEmailAndPassword(email, password);
	}

	@GetMapping(value = "/student/all")
	public ResponseEntity<ResponseStructure<List<Student>>> findAllStudent() {
		return service.findAllStudents();
	}

}
