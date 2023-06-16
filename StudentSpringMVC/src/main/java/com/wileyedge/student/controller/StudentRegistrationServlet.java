package com.wileyedge.student.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.wileyedge.student.model.Student;
import com.wileyedge.student.service.StudentService;


public class StudentRegistrationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	private Iservice iservice;
 
    public StudentRegistrationServlet() 
    {
        super();
        iservice = new StudentService();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Inside do get");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Inside do Post");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String mobileno = request.getParameter("mobileno");
		String address = request.getParameter("address");
		
		Student s = new Student(name,age,mobileno,address);
		List<Student> studList = new ArrayList<>();
		System.out.println(s.getMobileno());
		studList.add(s);
		service.saveStudentsInfo(studList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
		rd.forward(request, response);
	}

}
