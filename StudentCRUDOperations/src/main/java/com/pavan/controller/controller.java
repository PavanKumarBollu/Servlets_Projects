package com.pavan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pavan.dto.Student;
import com.pavan.service.IStudentService;
import com.pavan.servicefactory.StudentServiceFactory;


@WebServlet("/controller/*")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer sId = 100;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getRequestURI());
		System.out.println(request.getPathInfo());
		
		PrintWriter out = response.getWriter();
		if(request.getRequestURI().endsWith("addform"))
		{
			IStudentService studentService = StudentServiceFactory.getStudentService();
			String sName = request.getParameter("sname");
			String sAddress = request.getParameter("saddress");
			Integer sAge =Integer.parseInt(request.getParameter("sage"));
			Student student = new Student();
			student.setsId(sId++);
			student.setsName(sName);
			student.setsAge(sAge);
			student.setsAddress(sAddress);
			String result = studentService.addStudent(student);
			out.println("<h1> " + result + "</h1>");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);	
	}

}
