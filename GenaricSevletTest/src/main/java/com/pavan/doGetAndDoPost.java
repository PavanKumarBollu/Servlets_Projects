package com.pavan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/doGetAndDoPost")
public class doGetAndDoPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		genaralMethod(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		genaralMethod(request,response);
	}
	
	
	public void genaralMethod(HttpServletRequest request, HttpServletResponse response)
	{
		String uName = request.getParameter("uName");
		String uPassword = request.getParameter("uPassword");
		try {
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>HttpServlets</title></head>");
			out.println("<body><center><h1> Thank You for using our application </h1>");
			out.println("<p>UserName : " +uName + "</p>");
			out.println("<p>password : " +uPassword + "</p>");
			out.println("</center> </body> </html>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
