package com.pavan.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtils {
	private JdbcUtils() {
		//to prevent the object Creation
	}
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException, IOException
	{
		String fileLoc = "D:\\FullStack_Development\\5_Code__Projects\\2_BackEnd\\4_Servlets\\StudentCrudMVC\\src\\main\\java\\com\\pavan\\properties\\application.properties";
		HikariConfig config = new HikariConfig(fileLoc);
		try (HikariDataSource dataSource = new HikariDataSource(config)) {
			return dataSource.getConnection();
		}
		
	}
}
