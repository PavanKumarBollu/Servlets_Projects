package com.pavan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/rom")
public class RequestObjectMethods extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1> Request Object Mehotds to work the queryString</h1>");
		out.println("<h1> URI : " +request.getRequestURI() + "</h1>");
		out.println("<h1> ContextPath : " +request.getContextPath() + "</h1>");
		out.println("<h1> ServletPath : " +request.getServletPath() + "</h1>");
		out.println("<h1> PathInfo : " +request.getPathInfo() + "</h1>");
		out.println("<h1> QueryString : " +request.getQueryString() + "</h1>");
		
		out.println("<h1> RemoteUser : " +request.getRemoteHost() + "</h1>");
		out.println("<h1> RequestTypes : " +request.getMethod() + "</h1>");
		out.println("<h1> RequestURL : " +request.getRequestURL() + "</h1>");
		out.println("<h1> RemoteAddress : " +request.getRemoteAddr() + "</h1>");
		
		
	
	}

}
