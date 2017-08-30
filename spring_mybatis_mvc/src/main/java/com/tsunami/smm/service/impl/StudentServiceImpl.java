package com.tsunami.smm.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsunami.smm.mapper.StudentMapper;
import com.tsunami.smm.pojo.Student;
import com.tsunami.smm.pojo.StudentExample;
import com.tsunami.smm.service.StudentService;

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

	public int updateByExample(Student record) {
		return studentMapper.updateByPrimaryKeySelective(record);
	}

	public int deleteIds(String... ids) {
		return studentMapper.deleteIds(ids);
	}

	public List<Student> selectLikeByName(String string) {
		return studentMapper.selectLikeByName(string);
	}

}
