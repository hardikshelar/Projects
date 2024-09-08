package edu.jsp.__Student_Management_System.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.jsp.__Student_Management_System.dto.Student;
import edu.jsp.__Student_Management_System.student_repository.StudentRepository;

@Repository
public class StudentDao {
	@Autowired
	StudentRepository repository;

	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	public Student updateStudent(Student student) {
		return repository.save(student);
	}

	public Optional<Student> findStudentById(int id) {
		return repository.findById(id);
	}

	public void deleteStudent(int id) {
		repository.deleteById(id);
	}

	public Student findByPhoneAndPassword(long phone, String password) {
		return repository.findByPhoneAndPassword(phone, password);
	}

	public Student findByEmailAndPassword(String email, String password) {
		return repository.findByEmailAndPassword(email, password);
	}
	
	public List<Student> findAllStudent(){
		return repository.findAll();
	}

}
