package edu.jsp.__exception_handling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.__exception_handling.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
