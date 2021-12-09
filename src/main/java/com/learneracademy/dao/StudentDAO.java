package com.learneracademy.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learneracademy.entity.Classes;
import com.learneracademy.entity.Student;
import com.learneracademy.entity.Subject;
import com.learneracademy.entity.Teacher;

public class StudentDAO {

	
	public void saveStudent(Student studentName,String className){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class)
				.buildSessionFactory();
Session session=factory.getCurrentSession();
List<Integer> classes=null;
List<Integer> student=null;
		try {
			
			session.beginTransaction();
			
			classes =  session.createSQLQuery("select classId from class where className='"+className+"'").getResultList();
			int id=classes.get(0);
			Classes tempClass=session.get(Classes.class, id); 
			session.save(studentName);
			student = session.createSQLQuery("SELECT studentId FROM student WHERE first_name='"+studentName.getFirst_name()+"'").getResultList();
				 id=student.get(0);
				 System.out.println(id);
				 Student student2=session.get(Student.class, id);
				 System.out.println(student2.getFirst_name());
				 tempClass.addStudent(student2);
				 session.update(student2); 
				 System.out.println("Updated"); 
			 
		
			session.getTransaction().commit();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			session.close();
			factory.close();
		}
	}
	
	public List<String> GetStudent(){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class)
				.buildSessionFactory();
Session session=factory.getCurrentSession();
List<String> student=null;

							try {
								
								session.beginTransaction();
								
								System.out.println("Getting...");
								student=session.createSQLQuery("select first_name from student").list();						
								System.out.println(student);
								session.getTransaction().commit();
							}
							catch(Exception e) {
								
							}
							finally {
								session.close();
								factory.close();
							}
							return student;
	}

	public List<String> GetClassStudent(String className) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class)
				.buildSessionFactory();
Session session=factory.getCurrentSession();
List<Integer> classes=null;
	List<String> students=null;
	try {
		
		session.beginTransaction();
		classes =  session.createSQLQuery("select classId from class where className='"+className+"'").getResultList();
		int id=classes.get(0);
		System.out.println("id="+id);
		System.out.println("Getting...");
		students=session.createSQLQuery("select first_name from student where id="+id).list();						
		System.out.println(students);
		session.getTransaction().commit();
	}
	catch(Exception e) {
		
	}
	finally {
		session.close();
		factory.close();
	}
	return students;
	
	
}
}
