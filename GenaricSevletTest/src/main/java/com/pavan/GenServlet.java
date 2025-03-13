package com.pavan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;



import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class GenServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	
//	 Which init method is best suited for developer?
//			 init() => best suited for writing initialziation logic
	
	public void init() throws ServletException
	{
		System.out.println("init method got called");
	}


	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<h1>Genaric Servlet </h1>");
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
