package com.pavan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/rheader")
public class RequestHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html> <head> <title> Request Headers </title> </head>");
		out.println("<body> <center> <h1 style='color:red text-align:center;' > Header Information </h1>");
		out.println("<table border=2> " );
		out.println("<tr><th>HeaderName</th><th>HeaderValue</th></tr>");
				
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements())
		{
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			out.println("<tr><th>" + headerName + "</th><th>" + headerValue +"</th></tr>");
			
			
		}
		out.println("</center> </body> </html>");
	}

}
