package com.pavan.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DbCommunication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection = null;
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("DriverClassLoaded Sucussfully...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void init() throws ServletException
	{
		
		System.out.println("Servlet initializted and got the config Object form the init(ServletConfig config) method");
		String url = getInitParameter("url");
		String uName = getInitParameter("uName");
		String uPassword = getInitParameter("uPassword");
		System.out.println(url + uName + uPassword);
		try {
			connection = DriverManager.getConnection(url,uName,uPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PreparedStatement p = null;
		ResultSet r = null;
		try {
			String query = "select sId, sName, sAge, sAddress from student where sid= ?";
			if(connection!=null)
				p = connection.prepareStatement(query);
			p.setInt(1, 1);
			r = p.executeQuery();
			
			PrintWriter out = response.getWriter();
			out.println("<h1 style = 'text-align:center;'> Please find the Details of the StudentId 1</h1>");
			out.println("<table border = 2 align = 'center'>");
			out.println("<tr><th>StudentId</th><th>StudentName</th><th>studentAge</th><th>studentAddress</th></tr>");
			while(r.next())
			{
				out.println("<tr><td>" + r.getInt("sId") + "</td><td>"+ r.getString("sName") + 
						"</td><td>" + r.getInt("sAge") + "</td><td>" + r.getString("sAddress") + "</td></tr>");
			}
			
			out.println("</table>");
			r.close();
			p.close();
			connection.close();
			out.close();
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
