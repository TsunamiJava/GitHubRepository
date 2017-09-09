package com.tsunami.springhibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsunami.springhibernate.dao.StudentDAO;
import com.tsunami.springhibernate.entity.Student;
import com.tsunami.springhibernate.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	public List<Student> selectall(Class clazz) {
		return studentDAO.selectall(clazz);
	}

	public Student selectbyid(int id) {
		return studentDAO.selectbyid(id);
	}

	public void save(Student student) {
		studentDAO.save(student);
	}

	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	public void deletebyid(Student student) {
		studentDAO.deletebyid(student);
	}

	

}
