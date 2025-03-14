package com.pavan.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pavan.JdbcUtils.JdbcUtils;
import com.pavan.dto.Student;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String addStudent(Student student) {
		System.out.println(student.toString());
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = JdbcUtils.getJdbcConnection();
			if(connection != null)
			{
				String query = "insert into students(sid,sName,sAge,sAddress) values(?,?,?,?) where id = ? "; 
				statement = connection.prepareStatement(query);
				if(statement!=null)
				{
					statement.setInt(1, student.getsId());
					statement.setString(2, student.getsName());
					statement.setInt(3, student.getsAge());
					statement.setString(4, student.getsAddress());
					statement.setInt(5, student.getsId());
					int count = statement.executeUpdate();
					if(count != 0)
						return "DataInserted Sucessfully";
					else
						return "Can't Add The Student Data Please Try Again..!";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public Student searchStudent(Integer sId) {
		return null;
	}

	@Override
	public String updateStudent(Student student) {
		return null;
	}

	@Override
	public String deleteStudent(Integer sId) {
		return null;
	}

}
