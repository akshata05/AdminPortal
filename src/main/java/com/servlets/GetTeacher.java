package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learneracademy.dao.ClassesDAO;
import com.learneracademy.dao.SubjectDAO;
import com.learneracademy.dao.TeacherDAO;

/**
 * Servlet implementation class GetSubject
 */
@WebServlet("/GetTeacher")
public class GetTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDAO teacherDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	teacherDao=new TeacherDAO(); 
   }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String display=request.getParameter("display");
		List<String> teacher=teacherDao.GetTeacher();
		System.out.println("List"+teacher);
		 request.setAttribute("teacher", teacher);
		 if(display!=null)
		 {
			 RequestDispatcher dispatcher = request.getRequestDispatcher("view/Teacher.jsp");
		        dispatcher.forward(request, response);
		 }
		 else
		 {
			 RequestDispatcher dispatcher = request.getRequestDispatcher("GetClassSubject");
		        dispatcher.forward(request, response);
		
		 }
	}

}
