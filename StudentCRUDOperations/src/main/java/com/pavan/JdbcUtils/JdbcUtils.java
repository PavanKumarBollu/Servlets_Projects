package com.pavan.JdbcUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcUtils {
	
	private JdbcUtils() {}
	
	public static Connection getJdbcConnection() throws SQLException, IOException
	{
		String fileLoc = "D:\\FullStack_Development\\5_Code__Projects\\2_BackEnd\\4_Servlets\\StudentCRUDOperations\\src\\main\\java\\com\\pavan\\properties\\application.properties";
		FileInputStream fis = new FileInputStream(fileLoc);
		Properties properties = new Properties();
		
		properties.load(fis);
		String url =properties.getProperty("url");
		String uName =properties.getProperty("uName");
		String uPassword=properties.getProperty("uPassword");
		return DriverManager.getConnection("jdbc:mysql://localhost:9999/jdbc","root", "Pav@0211");
	}
}
