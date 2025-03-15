package com.pavan.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/testhikari")
public class testHikari extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection connection = JdbcUtils.getConnection();
			if(connection!= null)
			{
				String query = "select sid, sname, sage, sAddress from student where sid  = ?";
				PreparedStatement statement = connection.prepareStatement(query );
				
				statement.setInt(1, 1);
				ResultSet resultSet = statement.executeQuery();
				
				response.getWriter().println("<h1>"+ resultSet.getString("sName")+ "</h1>");
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
