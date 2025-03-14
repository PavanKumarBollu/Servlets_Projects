package com.pavan.service;

import com.pavan.dao.IStudentDao;
import com.pavan.daofactory.StudentDaoFactory;
import com.pavan.dto.Student;

public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao = null;
	@Override
	public String addStudent(Student student) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.addStudent(student);
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
