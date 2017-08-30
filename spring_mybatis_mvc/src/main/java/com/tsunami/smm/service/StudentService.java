package com.tsunami.smm.service;

import java.util.List;

import com.tsunami.smm.pojo.Student;
import com.tsunami.smm.pojo.StudentExample;

public interface StudentService {
	
	List<Student> selectByExample(StudentExample example);

	Student selectByPrimaryKey(Integer studentid);
	
	long countByExample(StudentExample example);
	
	int insert(Student record);
	
	int updateByExample(Student record);
	
	int deleteIds(String... ids);
	
	List<Student> selectLikeByName(String string);
	
}
