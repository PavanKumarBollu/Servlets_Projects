package com.pavan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/second")
public class second extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mActor = request.getParameter("mactor");
		
		
		HttpSession session = request.getSession();
		session.setAttribute("mactor", mActor);
		
		
		PrintWriter out = response.getWriter();
		out.println("<html> <head><title>Home</title></head>");
		out.println("<body><div style='display: flex; align-items: center; justify-content: center'>");
		out.println("<form method = 'post' action = '" +response.encodeUrl("./register") + "'>");
		out.println("<table border='2'>");
		out.println("<tr><th>DIRECTORNAME</th><td><input type = 'text' name = 'mdirector'/></td> </tr>");
		out.println("<tr><td></td><td><input type = 'submit' value = 'next' /></td> </tr>");
		
		
		
		
		
		out.println("</table></from></div></body></html>");
		out.close();
	}

}
