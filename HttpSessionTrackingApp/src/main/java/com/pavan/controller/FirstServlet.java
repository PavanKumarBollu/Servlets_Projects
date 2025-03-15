package com.pavan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sName = request.getParameter("sname");
		String sAge = request.getParameter("sage");
		
		HttpSession session = request.getSession();
		session.setAttribute("sname", sName);
		session.setAttribute("sAge", sAge);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/form2.html");
		requestDispatcher.forward(request, response);
	
	}

}
