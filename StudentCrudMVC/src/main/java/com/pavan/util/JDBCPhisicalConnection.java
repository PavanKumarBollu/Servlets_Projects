package com.pavan.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jpc")
public class JDBCPhisicalConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Sucessfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection connection = null;
		ResultSet r =null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql:///jdbc","root", "Pav@0211");
		if(connection != null)
		{
			String query = "select sid, sname, sage, sAddress from student where sid  = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, 1);
			
			r = ps.executeQuery();
			
			out.println("<h1 style = 'text-align:center;'> Please find the Details of the StudentId 1</h1>");
			out.println("<table border = 2 align = 'center'>");
			out.println("<tr><th>StudentId</th><th>StudentName</th><th>studentAge</th><th>studentAddress</th></tr>");
			while(r.next())
			{
				out.println("<tr><td>" + r.getInt("sId") + "</td><td>"+ r.getString("sName") + 
						"</td><td>" + r.getInt("sAge") + "</td><td>" + r.getString("sAddress") + "</td></tr>");
			}
			
			out.println("</table>");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
