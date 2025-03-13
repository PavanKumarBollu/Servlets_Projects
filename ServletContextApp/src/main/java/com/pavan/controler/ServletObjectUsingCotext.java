package com.pavan.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletObjectUsingCotext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
		
				PrintWriter out = response.getWriter();
				
				ServletContext context = getServletContext();
		
				out.println("<h1> context params using cotext object </h1>");
				ServletContext contextDirect = getServletContext();
				Enumeration<String> dpNames = contextDirect.getInitParameterNames();
				while(dpNames.hasMoreElements())
				{
					String paramName = (String) dpNames.nextElement();
					String paramValue = context.getInitParameter(paramName);
					out.println("<p> Param Name : " + paramName + "\t Param value : "+paramValue );
				}
				out.close();
	
	}

}
