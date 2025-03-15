package com.pavan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String sQual = request.getParameter("squal");
	String sDesg = request.getParameter("sdesg");
	HttpSession session = request.getSession(false);
	session.setAttribute("squal", sQual);
	session.setAttribute("sdesg", sDesg);
	
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/register.html");
	requestDispatcher.forward(request, response);
	
	}

}
