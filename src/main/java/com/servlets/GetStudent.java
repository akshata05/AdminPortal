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
import com.learneracademy.dao.StudentDAO;
import com.learneracademy.dao.SubjectDAO;

/**
 * Servlet implementation class GetSubject
 */
@WebServlet("/GetStudent")
public class GetStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudent() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	studentDao=new StudentDAO(); 
   }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		List<String> students=studentDao.GetStudent();
		System.out.println("List"+students);
		 request.setAttribute("students", students);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("view/GetStudent.jsp");
	        dispatcher.forward(request, response);
	
	}

}
