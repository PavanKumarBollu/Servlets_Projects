package com.pavan.include;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletinc1")
public class servletinc1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<h1> in servlet one </h1>");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servletinc2");
		requestDispatcher.include(request, response);
		out.println("<h1> leaving servlet one </h1>");
	
	}

}
