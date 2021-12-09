package com.learneracademy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="class")
public class Classes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="classId")
	private int classId;
	
	@Column(name="className")
	private String className;
	
	@OneToMany(mappedBy="classes",cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Subject> subjects;
	
	@OneToMany(mappedBy="classes",cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Student> students;
	
	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Classes(String className) {
		
		this.className = className;
	}

	public Classes() {
		
	}

	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", className=" + className + "]";
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public void add(Subject subject)
	{
		
		
		subject.setClasses(this);
	}
	
	public void addStudent(Student student)
	{
		
		
		student.setClasses(this);
	}
	
}
