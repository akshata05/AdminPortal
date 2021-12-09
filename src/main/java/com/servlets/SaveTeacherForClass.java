package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learneracademy.dao.ClassesDAO;
import com.learneracademy.dao.TeacherDAO;

/**
 * Servlet implementation class SaveTeacherForClass
 */
@WebServlet("/SaveTeacherForClass")
public class SaveTeacherForClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TeacherDAO teacherDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveTeacherForClass() {
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
		String className= request.getParameter("class");
		String teacherName= request.getParameter("teacher");
		String subjectName = request.getParameter("mySubjects");
		System.out.println("class="+className+"teacher="+teacherName+"subjectName"+subjectName);
		teacherDao.SaveTeacherToSubject(className, teacherName, subjectName);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/Success.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
