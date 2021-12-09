package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learneracademy.dao.ClassesDAO;
import com.learneracademy.dao.StudentDAO;
import com.learneracademy.dao.SubjectDAO;
import com.learneracademy.dao.TeacherDAO;
import com.learneracademy.entity.Student;
import com.learneracademy.entity.Teacher;

/**
 * Servlet implementation class GetSubject
 */
@WebServlet("/GetReport")
public class GetReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassesDAO classesDao;  
	private StudentDAO studentDao;
	private TeacherDAO teacherDao;
	private SubjectDAO subjectDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReport() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
   	 classesDao=new ClassesDAO(); 
   	studentDao=new StudentDAO(); 
   	teacherDao=new TeacherDAO(); 
 	subjectDao=new SubjectDAO(); 
   }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
    	String classes=request.getParameter("myClasses");
    	
    	List<String> subject=subjectDao.GetClassSubject(classes);
    	List<String> student=studentDao.GetClassStudent(classes);
    	List<String> teacher=teacherDao.GetClassTeacher(classes);
    	if(subject==null) {subject=new ArrayList();subject.add("No data available");}
    	
    	if(student==null) {student=new ArrayList();student.add("No data available");}
    	if(teacher==null) {teacher=new ArrayList();teacher.add("No data available");}
    	request.setAttribute("subject", subject);
    	request.setAttribute("teacher", teacher);
			System.out.println(subject+" "+student+" "+teacher);
  	request.setAttribute("student", student);	    
    	
  	 RequestDispatcher dispatcher = request.getRequestDispatcher("view/GetClassReport.jsp");
     dispatcher.forward(request, response);
	}

}
