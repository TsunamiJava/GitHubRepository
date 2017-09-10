package com.tsunami.ssh.dao;

import java.util.List;

import com.tsunami.ssh.entity.Student;

public interface StudentDAO {

	public List<Student> selectall();
	
	public List<Student> selectlike(String sreach);
	
	public Student selectbyid(int id);
	
	public void save(Student student);
	
	public void updateStudent(Student student);
	
	public void deletebyid(Student student);
	
	
}
