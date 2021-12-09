package com.learneracademy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learneracademy.entity.Classes;
import com.learneracademy.entity.Student;
import com.learneracademy.entity.Subject;
import com.learneracademy.entity.Teacher;

public class SubjectDAO {


	
	public void SaveSubject(String subjectName) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class)
				.buildSessionFactory();
Session session=factory.getCurrentSession();

							try {
								Subject subject=new Subject(subjectName);
								session.beginTransaction();
								
								System.out.println("Saving..");
								session.save(subject);								
								session.getTransaction().commit();
							}
							catch(Exception e) {
								
							}
							finally {
								session.close();
								factory.close();
							}
	}
	
	public List<String> GetSubject(){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class)
				.buildSessionFactory();
Session session=factory.getCurrentSession();
List<String> subjects=null;

							try {
								
								session.beginTransaction();
								
								System.out.println("Getting...");
								subjects=session.createSQLQuery("select subjectName from subject").list();						
								System.out.println(subjects);
								session.getTransaction().commit();
							}
							catch(Exception e) {
								
							}
							finally {
								session.close();
								factory.close();
							}
							return subjects;
	}
	public List<String> GetClassSubject(String className){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class)
				.buildSessionFactory();
Session session=factory.getCurrentSession();
List<Integer> classes=null;
	List<String> subjects=null;
	try {
		
		session.beginTransaction();
		classes =  session.createSQLQuery("select classId from class where className='"+className+"'").getResultList();
		int id=classes.get(0);
		System.out.println("id="+id);
		System.out.println("Getting...");
		subjects=session.createSQLQuery("select subjectName from subject where classId="+id).list();						
		System.out.println(subjects);
		session.getTransaction().commit();
	}
	catch(Exception e) {
		
	}
	finally {
		session.close();
		factory.close();
	}
	return subjects;
	}
}
