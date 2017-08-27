package com.tsunami.mybatisdemo.service;

import java.util.List;

import com.tsunami.mybatisdemo.pojo.Student;
import com.tsunami.mybatisdemo.pojo.StudentExample;

public interface StudentService {
	//查找全部
	List<Student> selectByExample(StudentExample example);
	//id查找
	Student selectByPrimaryKey(Integer studentid);
	//统计表的数据
	long countByExample(StudentExample example);
	//插入数据
	int insert(Student record);
	//修改数据
	int updateByPrimaryKey(Student record);
	//批量删除
	boolean deleteIds(String... ids);
	//模糊查找
	List<Student> selectLikeByName(String string);
}
