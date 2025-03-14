package com.pavan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alsa")
public class ApplicationLevelScopeAttrbutes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		
		context.setAttribute("url", "jdbc:mysql:///jdbc");
		context.setAttribute("uName", "root");
		context.setAttribute("uPassword", "Pav@0211");
		
		out.println("<html><head><title>ApplicationLevelScope OR ContextScope</title><head>");
		out.println("<body><center> <h1> ApplicationScope Level Attributes </h1>");
		out.println("<table border = 1 > <tr><th>AttributeName</th> <th>AttributeValue</th></tr>");
		

		Enumeration<String> attributes = context.getAttributeNames();
		while(attributes.hasMoreElements())
		{
			System.out.println("working");
			String attributeName = attributes.nextElement();
			Object attributeValue =  context.getAttribute(attributeName);
			out.println("<tr><th>" + attributeName + "</th><th>" + attributeValue + "</th></tr>");
		}
		out.println("</center></table></body></html>");
		out.close();
		
	
	}

}
