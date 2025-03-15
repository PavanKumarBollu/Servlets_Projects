package com.pavan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String pName = request.getParameter("pname");
	String pBrand = request.getParameter("pbrand");
	
	Cookie c1 = new Cookie("pname", pName);
	Cookie c2 = new Cookie("pbrand", pBrand);
	
	response.addCookie(c1);
	response.addCookie(c2);
	
	
	RequestDispatcher rd = request.getRequestDispatcher("/register.html");
	rd.forward(request, response);
	}

}
