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


@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String pQty = request.getParameter("pqty");
		String pCost = request.getParameter("pcost");
		
		
		Cookie c3 = new Cookie("pcost", pCost);
		Cookie c4 = new Cookie("pqty", pQty);
		
		response.addCookie(c3);
		response.addCookie(c4);
		
		out.println("<html> <head><title>Home</title></head>");
		out.println("<body><div style='display: flex; align-items: center; justify-content: center'> <table border='2'>");
		out.println("<tr><th>PropertyName</th><th>PropertyValue</th> </tr>");
		
		Cookie[] cookies = request.getCookies();
		cookies[0].getName();
		cookies[0].getValue();
		for(Cookie c:cookies)
		{
			out.println("<tr><td>" +c.getName() +"</td><td>" +c.getValue() + "</td></tr>");
		}
		
		
		
		out.println("</table></div></body></html>");
	
	}

}
