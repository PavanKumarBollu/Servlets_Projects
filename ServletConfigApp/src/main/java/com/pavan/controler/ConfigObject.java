package com.pavan.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConfigObject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Initialization Parameters </title><head>");
		out.println("<body><h1 style = 'text-align:center;'>Initialization parameters Using the Xml Approach </h1>");
		out.println("<table border= 2 align ='center'> ");
		out.println("<tr><th>ParameterName</th><th>ParameterValue</th></tr>");
		
		Enumeration<String> pNames = getInitParameterNames();
		while(pNames.hasMoreElements())
		{
			String pName = (String) pNames.nextElement();
			String pValue = getInitParameter(pName);
			
			out.println("<tr><th>"+pName+ "</th><th>" + pValue+"</th>");
			
		}
			out.println("</table></body><html>");		
			out.close();
		
	}

}
