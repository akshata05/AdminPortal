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

/**
 * Servlet implementation class GetClassSubject
 */
@WebServlet("/GetClassSubject")
public class GetClassSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassesDAO classesDao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetClassSubject() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
      	 classesDao=new ClassesDAO(); 
      }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> classes=classesDao.GetClasses();
		System.out.println("List"+classes);
		 request.setAttribute("classes", classes);
    	
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/AssignTeacher.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
