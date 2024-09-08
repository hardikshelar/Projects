package edu.jsp.__response_structure.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.__response_structure.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
