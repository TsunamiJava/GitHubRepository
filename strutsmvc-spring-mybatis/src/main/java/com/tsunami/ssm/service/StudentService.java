package com.tsunami.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tsunami.ssm.pojo.Student;
import com.tsunami.ssm.pojo.StudentExample;


public interface StudentService {
	List<Student> selectByExample(StudentExample example);

	Student selectByPrimaryKey(Integer studentid);
	
	long countByExample(StudentExample example);
	
	int insert(Student record);
	
	int updateByPrimaryKeySelective(Student record);
	
	int deleteIds(String... ids);
	
	List<Student> selectLikeByName(String string);
}
