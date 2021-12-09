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
@WebServlet("/GetSubject")
public class GetSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubjectDAO subjectDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSubject() {
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
    	String display=request.getParameter("display");
		List<String> subjects=subjectDao.GetSubject();
		System.out.println("List"+subjects);
		 request.setAttribute("subjects", subjects);
		 if(display!=null) {
			 RequestDispatcher dispatcher = request.getRequestDispatcher("view/DisplaySubject.jsp");
		        dispatcher.forward(request, response);
		 }
		 else {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("view/CreateClass.jsp");
	        dispatcher.forward(request, response);
		 }
	
	}

}
