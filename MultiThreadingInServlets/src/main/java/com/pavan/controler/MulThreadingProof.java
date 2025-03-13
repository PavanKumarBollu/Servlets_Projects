package com.pavan.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mtfroof")
public class MulThreadingProof extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>MultiThreadinInServlets</title></head>");
		out.println("<body> <h1>MultiThreading Is Used in servlets for accesing the objects</h1>");
		out.println("<p style='font-size:30px'> servlet request object address is 		:" + request.hashCode() + "</p>");
		out.println("<p style= 'font-size:30px'>servlet response object address is 		:" + response.hashCode() + "</p>");
		out.println("<p style = 'font-size:30px '> Current Servlet Object Reference is 	:" + this.hashCode() + "</p>");
		out.println("<p style = 'font-size:30px' > Current Servlet Thread Executing 	:" + Thread.currentThread().hashCode() + "</p>");
				
		
		
		
		
	}

}
