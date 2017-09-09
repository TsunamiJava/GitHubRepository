package com.tsunami.springhibernate.service;

import java.util.List;

import com.tsunami.springhibernate.entity.Student;

public interface StudentService {

public List<Student> selectall(Class clazz);
	
	public Student selectbyid(int id);
	
	public void save(Student student);
	
	public void updateStudent(Student student);
	
	public void deletebyid(Student student);

}
