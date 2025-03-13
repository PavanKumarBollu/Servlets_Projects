package com.pavan.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns= "/ipua" ,loadOnStartup = 10, initParams = {
		@WebInitParam(name ="url", value = "jdbs:mysql:///jdbc"),
		@WebInitParam(name= "uName", value = "root"),
		@WebInitParam(name="uPassword", value = "Pav@0211")
})
public class InitParametersUsingAnnotaions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Initialization Parameters</title><head>");
		out.println("<body><h1 style = 'text-align:center;'>Initialization parameters using annotation Approach </h1>");
		out.println("<table border= 2 align ='center'> ");
		out.println("<tr><th>ParameterName</th><th>ParameterValue</th></tr>");
		
		Enumeration<String> params = getInitParameterNames();
		while(params.hasMoreElements())
		{
			String paramName = params.nextElement();
			String paramValue = getInitParameter(paramName);
			out.println("<tr> <td>"+ paramName + "</td><td>"+ paramValue +"</td><tr>");
		}
		
		out.println("</table></body></html>");
		out.close();
	}

}
