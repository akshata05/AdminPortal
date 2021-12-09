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
import com.learneracademy.dao.TeacherDAO;
import com.learneracademy.entity.Teacher;

/**
 * Servlet implementation class SaveClass
 */
@WebServlet("/SaveTeacher")
public class SaveTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDAO teacherDao;
	  public void init() {
		  teacherDao=new TeacherDAO(); 
		   }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		Teacher teacher=new Teacher(first_name,last_name,email);
		teacherDao.saveTeacher(teacher);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/Success.jsp");
	    dispatcher.forward(request, response);
		
		
	}

}
