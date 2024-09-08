package edu.jsp.__pass_json_object_using_request_body.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.__pass_json_object_using_request_body.Student;

@RestController
public class Controller {
@PostMapping("/student")
public String getData(@RequestBody Student student) {
	return "Student Id : "+student.getId()+"\nStudent Name : "+student.getName()+"\nStudent height : "+student.getHeight()+"\nStudent Weight : "+student.getWeight();
}
}
