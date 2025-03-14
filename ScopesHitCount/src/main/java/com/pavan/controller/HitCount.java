package com.pavan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hitcount")
public class HitCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		
		Integer count = (Integer) context.getAttribute("hitCount");
		if(count == null)
			count = 1;
		else
			count++;
		
		context.setAttribute("hitCount", count);
		
		
		out.println("<h1>Web hit Count "+ count + "</h1>");
		
		
	
	
	}

}
