package com.learneracademy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="studentId")
private int studentId;

public Student() {

}

public int getStudentId() {
	return studentId;
}

public void setStudentId(int studentId) {
	this.studentId = studentId;
}

public String getFirst_name() {
	return first_name;
}

public void setFirst_name(String first_name) {
	this.first_name = first_name;
}

public String getLast_name() {
	return last_name;
}

public void setLast_name(String last_name) {
	this.last_name = last_name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Classes getClasses() {
	return classes;
}

public void setClasses(Classes classes) {
	this.classes = classes;
}

public Student(String first_name, String last_name, String email) {
	
	this.first_name = first_name;
	this.last_name = last_name;
	this.email = email;
}

@Override
public String toString() {
	return "Student [studentId=" + studentId + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
			+ email + ", classes=" + classes + "]";
}

@Column(name="first_name")
private String first_name;

@Column(name="last_name")
private String last_name;

@Column(name="email")
private String email;

@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
@JoinColumn(name="id")
private Classes classes;



	
}
