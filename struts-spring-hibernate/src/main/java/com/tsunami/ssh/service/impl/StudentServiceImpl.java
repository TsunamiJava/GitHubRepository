package com.tsunami.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsunami.ssh.dao.StudentDAO;
import com.tsunami.ssh.entity.Student;
import com.tsunami.ssh.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	public List<Student> selectall() {
		return studentDAO.selectall();
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

	public List<Student> selectlike(String sreach) {
		return studentDAO.selectlike(sreach);
	}

}
