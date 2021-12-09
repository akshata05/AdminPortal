package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learneracademy.dao.SubjectDAO;

/**
 * Servlet implementation class GetSubject
 */
@WebServlet("/GetSubjectForClass")
public class GetSubjectForClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectDAO subjectDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSubjectForClass() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
   	 subjectDao=new SubjectDAO(); 
   }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	
		String className = request.getParameter("myClasses");
		String teacherName=request.getParameter("myTeacher");
		List<String> subjects=subjectDao.GetClassSubject(className);
		System.out.println(className+" and"+teacherName);
		 request.setAttribute("subjects", subjects);
		 request.setAttribute("teacher", teacherName);
		 request.setAttribute("class", className);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("view/TeacherSubject.jsp");
	        dispatcher.forward(request, response);
		
	
	
	}

}
