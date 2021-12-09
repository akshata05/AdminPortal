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

/**
 * Servlet implementation class GetSubject
 */
@WebServlet("/GetClass")
public class GetClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassesDAO classesDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetClass() {
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
    	
    	String report=request.getParameter("report");
    	String display=request.getParameter("display");
       	List<String> classes=classesDao.GetClasses();
    		System.out.println("List"+classes);
    		 request.setAttribute("classes", classes);
        	
    	if(report!=null) {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("view/GetClasses.jsp");
		    dispatcher.forward(request, response);
    		
    	}
    	else if(display!=null)
    	{
    		RequestDispatcher dispatcher = request.getRequestDispatcher("view/DisplayClass.jsp");
		    dispatcher.forward(request, response);
    	}
    	else {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("view/CreateStudent.jsp");
		    dispatcher.forward(request, response);
    	}
    	
 
			
			    
    	
	
	}

}
