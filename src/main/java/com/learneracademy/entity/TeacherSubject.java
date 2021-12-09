package com.learneracademy.entity;

import java.io.Serializable;
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
@Table(name="assignteacher")
public class TeacherSubject implements Serializable{
	public TeacherSubject(int classId, int subjectId, int teacherId) {
		
		this.classId = classId;
		this.subjectId = subjectId;
		this.teacherId = teacherId;
	}

	public TeacherSubject() {
	
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		return "TeacherSubject [classId=" + classId + ", subjectId=" + subjectId + ", teacherId=" + teacherId + "]";
	}

	@Id
	@Column(name="class_Id")
	private int classId;
	
	@Id
	@Column(name="subject_Id")
	private int subjectId;
	
	@Id
	@Column(name="teacherId")
	private int teacherId;
	
	
}
