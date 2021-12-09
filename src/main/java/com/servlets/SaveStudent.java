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
import com.learneracademy.dao.StudentDAO;
import com.learneracademy.dao.SubjectDAO;
import com.learneracademy.entity.Student;

/**
 * Servlet implementation class SaveClass
 */
@WebServlet("/SaveStudent")
public class SaveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDao;
	  public void init() {
		  studentDao=new StudentDAO(); 
		   }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String names = request.getParameter("myClasses");
		List list = Arrays.asList(names);
		String first_name=request.getParameter("name");
		String lastName = request.getParameter("last_name");
		String email=request.getParameter("email");
		Student student=new Student(first_name,lastName,email);
		studentDao.saveStudent(student, names);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/Success.jsp");
	    dispatcher.forward(request, response);
		
		
	}

}
