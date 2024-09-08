package edu.jsp.__Student_Management_System.student_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.__Student_Management_System.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	Student findByPhoneAndPassword(long phone, String password);
	
	Student findByEmailAndPassword(String email, String password);
}
