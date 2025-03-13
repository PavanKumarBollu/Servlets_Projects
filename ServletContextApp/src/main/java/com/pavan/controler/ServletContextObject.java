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
				String paramName = paramNames.nextElement();
				String paramValue = getInitParameter(paramName);
				out.println("<p> Param Name : " + paramName + "\t Param value : "+paramValue );
			}
			
			
		
		
		// 2nd Ways
			out.println("<h1> context params using cotext object </h1>");
		ServletContext contextDirect = getServletContext();
		Enumeration<String> dpNames = contextDirect.getInitParameterNames();
		while(dpNames.hasMoreElements())
		{
			String paramName = dpNames.nextElement();
			String paramValue = getInitParameter(paramName);
			out.println("<p> Param Name : " + paramName + "\t Param value : "+paramValue );
		}
		out.close();
		
	}

}
