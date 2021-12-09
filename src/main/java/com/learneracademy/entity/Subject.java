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
@Table(name="subject")
public class Subject {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="subjectId")
private int id;

@Column(name="subjectName")
private String name;

@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
@JoinColumn(name="classId")
private Classes classes;

public Subject() {
	
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

public Subject(String name) {

	this.name = name;
}

@Override
public String toString() {
	return "Subject [id=" + id + ", name=" + name + "]";
}

public Classes getClasses() {
	return classes;
}

public void setClasses(Classes classes) {
	this.classes = classes;
}


	
}
