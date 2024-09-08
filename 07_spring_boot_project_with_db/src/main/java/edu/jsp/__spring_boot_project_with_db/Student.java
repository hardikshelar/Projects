package edu.jsp.__spring_boot_project_with_db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
@Id
private int id;
private String name;

private double height;
private double weight;



public Student() {
	super();
}
public Student(int id, String name, double height, double weight) {
	
	this.id = id;
	this.name = name;
	this.height = height;
	this.weight = weight;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getHeight() {
	return height;
}
public void setHeight(double height) {
	this.height = height;
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}
}
