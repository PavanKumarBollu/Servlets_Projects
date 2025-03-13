package com.pavan.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletContextObject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1st way
		ServletConfig config = getServletConfig();
		ServletContext context = config.getServletContext();
		
			PrintWriter out = response.getWriter();
			out.println("<h1> Context Parameters using the config object</h1>");
			
			Enumeration<String> paramNames = context.getInitParameterNames();
			while(paramNames.hasMoreElements())
			{
				String paramName = (String) paramNames.nextElement();
				String paramValue = context.getInitParameter(paramName);
				out.println("<p> Param Name : " + paramName + "\t Param value : "+paramValue );
			}
			
			out.close();
		
	}

}
