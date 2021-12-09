package com.learneracademy.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learneracademy.entity.Classes;
import com.learneracademy.entity.Student;
import com.learneracademy.entity.Subject;
import com.learneracademy.entity.Teacher;

public class ClassesDAO {

	
	public void SaveClassesAndSubject(List<String> subjectName,String className){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class)
				.buildSessionFactory();
Session session=factory.getCurrentSession();
List<Integer> classes=null;
List<Integer> subject=null;
		try {
			
			session.beginTransaction();
			Classes classes2=new Classes(className);			
			session.save(classes2);
			classes =  session.createSQLQuery("select classId from class where className='"+className+"'").getResultList();
			int id=classes.get(0);
			Classes tempClass=session.get(Classes.class, id); 
			
			for(String s: subjectName)
			{ 
				System.out.println("Subject="+s); 
				subject = session.createSQLQuery("SELECT subjectId FROM subject WHERE subjectName='"+s+"'").getResultList();
				 id=subject.get(0);
				 System.out.println(id);
				 Subject subject2=session.get(Subject.class, id);
				 System.out.println(subject2.getName());
				 tempClass.add(subject2);
				 session.update(subject2); 
				 System.out.println("Updated"); 
			 }
		
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
	
	public List<String> GetClasses(){
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
Session session=factory.getCurrentSession();
List<String> classes=null;

							try {
								
								session.beginTransaction();
								
								System.out.println("Getting...");
								classes=session.createSQLQuery("select className from class").list();						
								System.out.println(classes);
								session.getTransaction().commit();
							}
							catch(Exception e) {
								
							}
							finally {
								session.close();
								factory.close();
							}
							return classes;
	}
	
}
