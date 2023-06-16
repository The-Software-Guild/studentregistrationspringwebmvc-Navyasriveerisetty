package com.wileyedge.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wileyedge.student.dao.StudentDao;
import com.wileyedge.student.dao.StudentDaoImpl;
import com.wileyedge.student.model.Student;



@Service
public class StudentService implements Iservice 
{

    @Autowired

    private StudentDaoImpl studentDaoi;
    

	@Override
	public void addStudent(Student student) 
	{
		
		studentDaoi.addStudent(student);
	}

}


	

