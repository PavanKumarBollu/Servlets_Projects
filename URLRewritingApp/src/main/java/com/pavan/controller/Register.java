package com.pavan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mDirector = request.getParameter("mdirector");
		
		
		HttpSession session = request.getSession();
		session.setAttribute("mdirector", mDirector);
		
		
		PrintWriter out = response.getWriter();
		out.println("<html> <head><title>Home</title></head>");
		out.println("<body><div style='display: flex; align-items: center; justify-content: center'>");
		out.println("<table border='2'>");
		out.println("<tr><th>NAME</th><th>VALUE</th> </tr>");
		
		Enumeration<String> attributeNames = session.getAttributeNames();
		while(attributeNames.hasMoreElements())
		{
			String eName = attributeNames.nextElement();
			Object eValue = session.getAttribute(eName);
			out.println("<tr><td>" + eName +"</td><td>" +eValue + "</td> </tr>");
		}
		out.println("</table></from></div></body></html>");
		out.close();
	}

}
