package com.tsunami.ssm.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsunami.ssm.mapper.StudentMapper;
import com.tsunami.ssm.pojo.Student;
import com.tsunami.ssm.pojo.StudentExample;
import com.tsunami.ssm.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(StudentServiceImpl.class);
	@Autowired
	private StudentMapper studentMapper;
	
	public List<Student> selectByExample(StudentExample example) {
		return studentMapper.selectByExample(example);
	}

	public Student selectByPrimaryKey(Integer studentid) {
		return studentMapper.selectByPrimaryKey(studentid);
	}

	public long countByExample(StudentExample example) {
		return studentMapper.countByExample(example);
	}

	public int insert(Student record) {
		return studentMapper.insert(record);
	}

	public int deleteIds(String... ids) {
		return studentMapper.deleteIds(ids);
	}

	public List<Student> selectLikeByName(String string) {
		return studentMapper.selectLikeByName(string);
	}

	public int updateByPrimaryKeySelective(Student record) {
		return studentMapper.updateByPrimaryKey(record);
	}

	

}
