package com.pavan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sMobile = request.getParameter("smobile");
		String sEmail = request.getParameter("semail");
		
		HttpSession session = request.getSession(false);
		session.setAttribute("smobile", sMobile);
		session.setAttribute("semail", sEmail);
		
		PrintWriter out = response.getWriter();
		out.println("<html> <head><title>Home</title></head>");
		out.println("<body><div style='display: flex; align-items: center; justify-content: center'> <table border='2'>");
		out.println("<tr><th>PropertyName</th><th>PropertyValue</th> </tr>");
		
		Enumeration<String> names = session.getAttributeNames();
		while(names.hasMoreElements())
		{
			String name = names.nextElement();
			Object value = session.getAttribute(name);
			out.println("<tr><td> " + name + " </td><td> "+ value+ " </td></tr>");
			
		}
		
		out.println("</table></div></body></html>");
		out.close();
		
	
		System.out.println(request.getRequestedSessionId());
//		session.invalidate();
		System.out.println();
	}
	


}
