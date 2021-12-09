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
 * Servlet implementation class SaveSubject
 */
@WebServlet("/SaveSubject")
public class SaveSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private SubjectDAO subjectDao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */

    public void init() {
    	 subjectDao=new SubjectDAO(); 
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		 String subjectName=request.getParameter("subjectName"); 
		
		 subjectDao.SaveSubject(subjectName);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/Success.jsp");
	    dispatcher.forward(request, response);
	}
	
}
