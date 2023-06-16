package com.wileyedge.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import com.wileyedge.student.model.Student;

@Component
public class StudentDaoImpl implements StudentDao 
{

	private ServletContext servletContext;
	
	public StudentDaoImpl(ServletContext servletContext) 
	{
		this.servletContext = servletContext;
	}

	public Connection openConnection() {
		Connection con = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/studentregistration", "root", "root");
			System.out.println("MySQL driver registered");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("MySQL suitable driver not found ");
			e.printStackTrace();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeConnection(Connection con) 
	{
		try 
		{
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void addStudent(Student s) 
	{
		System.out.println("Inside student");
		String name = s.getName();
		String mobileno = s.getMobileno();
		int age = s.getAge();
		String address = s.getAddress();
		
		Connection con = openConnection();
		
		try 
		{			
			String sql = "INSERT INTO STUDENT(NAME, AGE, MOBILENO, ADDRESS) VALUES(?,?,?,?)";
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, name);
			pstat.setLong(2, age);
			pstat.setString(3, mobileno);
			pstat.setString(4, address);
			int n = pstat.executeUpdate();
			

			System.out.println("Number of rows inserted "+ n);
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		closeConnection(con);	
	}

}