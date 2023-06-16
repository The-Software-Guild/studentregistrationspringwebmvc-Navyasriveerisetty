package com.wileyedge.student.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wileyedge.student.model.Student;
import com.wileyedge.student.service.StudentService;


@Controller
public class StuController
{

	@Autowired
	StudentService service;
	
	@RequestMapping(value = "/register.htm", method = RequestMethod.GET)
	public String showStudentForm(Map<String, Student> map) 
	{
		
		map.put("s", new Student());
		
		return "studentForm";
	}

	@RequestMapping(value = "savestu.htm", method = RequestMethod.POST)
	public String persistStudent(String name, int age, String mobileno, String address, Map<String, Student> map) 
	{

		Student student = new Student(name, age, mobileno, address);
		service.addStudent(student);
		map.put("s", student);
		return "success";
	}

}