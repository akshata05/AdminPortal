package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learneracademy.dao.ClassesDAO;
import com.learneracademy.dao.SubjectDAO;

/**
 * Servlet implementation class SaveClass
 */
@WebServlet("/SaveClass")
public class SaveClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassesDAO classesDao;
	  public void init() {
		   	 classesDao=new ClassesDAO(); 
		   }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] names = request.getParameterValues("myCheck");
		List list = Arrays.asList(names);
		String className=request.getParameter("name");
		classesDao.SaveClassesAndSubject(list,className);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/Success.jsp");
	    dispatcher.forward(request, response);
		
		
		
	}

}
