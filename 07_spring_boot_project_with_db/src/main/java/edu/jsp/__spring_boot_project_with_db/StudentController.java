package edu.jsp.__spring_boot_project_with_db;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	@PostMapping("/save")
	public String saveStudent(@RequestBody Student student) {
		studentRepo.save(student);
		return "Body mil gayi!";
		
	}
	@GetMapping(value = "/fetch", produces=MediaType.APPLICATION_XML_VALUE)
	public String fetchStudent(@RequestParam int id) {
		Optional<Student> findById = studentRepo.findById(id);
		Student student = findById.get();
		
		return "Student Details : "+student.getName()+"\n"+student.getHeight();
	}
	@DeleteMapping("/delete")
	public String deleteStudent(@RequestHeader int id) {
//		Optional<Student> findById = studentRepo.findById(id);
//		Student student = findById.get();
//	studentRepo.delete(student);
		studentRepo.deleteById(id);
		return "Student Deleted Successfully";
	}
	
	@PutMapping("/update/{id}/{height}")
	public String updateStudent(@PathVariable int id , @PathVariable double height) {
		Optional<Student> findById = studentRepo.findById(id);
		
		  Student student = findById.get();
		  student.setHeight(height);
		studentRepo.save(student);
		return "Student updated Successfully";
	}
}
