package com.learneracademy.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learneracademy.entity.Classes;
import com.learneracademy.entity.Student;
import com.learneracademy.entity.Subject;
import com.learneracademy.entity.Teacher;
import com.learneracademy.entity.TeacherSubject;

public class TeacherDAO {

	
	public void saveTeacher(Teacher teacher){
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
			
		
			session.save(teacher);
			 
			 
		
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
	
	public List<String> GetTeacher(){
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
								student=session.createSQLQuery("select first_name from teacher").list();						
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
	
	public void SaveTeacherToSubject(String className,String teacherName,String subjectName) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(Classes.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherSubject.class)
				.buildSessionFactory();
Session session=factory.getCurrentSession();
List<Integer> classes=null;
List<Integer> subject=null;
List<Integer> teacher=null;
		try {
			
			session.beginTransaction();
			
			classes =  session.createSQLQuery("select classId from class where className='"+className+"'").getResultList();
			int classid=classes.get(0);
			subject =  session.createSQLQuery("select subjectId from subject where subjectName='"+subjectName+"'").getResultList();
			int subjectid=subject.get(0);
			teacher =  session.createSQLQuery("select teacherId from teacher where first_name='"+teacherName+"'").getResultList();
			int teacherid=teacher.get(0);
			TeacherSubject ts=new TeacherSubject(classid,subjectid,teacherid);
			
			session.save(ts);
			
			 
		
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

	public List<String> GetClassTeacher(String className) {
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
	List<Integer> teacher=null;
	List<String> teacherName=new ArrayList();
	List<String> tempTeacher=null;
	try {
		
		session.beginTransaction();
		classes =  session.createSQLQuery("select classId from class where className='"+className+"'").getResultList();
		int id=classes.get(0);
		System.out.println("id="+id);
		System.out.println("Getting...");
		teacher=(List<Integer>) session.createSQLQuery("select teacherId from assignteacher where class_Id="+id).getResultList();					
		System.out.println(teacher.get(0));
	for(int i=0;i<teacher.size();i++)
	{
		tempTeacher =  session.createSQLQuery("select first_name from teacher where teacherId="+teacher.get(i)).getResultList();
		System.out.println(tempTeacher.get(0));
		teacherName.add(tempTeacher.get(0));
		System.out.println("Teacher="+teacherName.get(0));
		
	}	
		
		session.getTransaction().commit();
	}
	catch(Exception e) {
		
	}
	finally {
		session.close();
		factory.close();
	}
	return teacherName;
	
}
}
