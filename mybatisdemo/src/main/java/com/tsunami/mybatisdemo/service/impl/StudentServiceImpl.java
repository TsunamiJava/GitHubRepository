package com.tsunami.mybatisdemo.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.tsunami.mybatisdemo.mapper.StudentMapper;
import com.tsunami.mybatisdemo.pojo.Student;
import com.tsunami.mybatisdemo.pojo.StudentExample;
import com.tsunami.mybatisdemo.service.StudentService;
import com.tsunami.mybatisdemo.utils.MybatisUtils;

public class StudentServiceImpl implements StudentService {
	
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(StudentServiceImpl.class);

	public List<Student> selectByExample(StudentExample example) {
		SqlSession session=MybatisUtils.getFactory().openSession();
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		List<Student> students=mapper.selectByExample(example);
		session.close();
		return students;
	}

	public List<Student> selectLikeByName(String string) {
		SqlSession session=MybatisUtils.getFactory().openSession();
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		List<Student> list= mapper.selectLikeByName(string);
		session.close();
		return list;
	}
	
	public Student selectByPrimaryKey(Integer studentid) {
		SqlSession session=MybatisUtils.getFactory().openSession();
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		Student student=mapper.selectByPrimaryKey(studentid);
		session.close();
		return student;
	}

	public long countByExample(StudentExample example) {
		SqlSession session=MybatisUtils.getFactory().openSession();
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		long num=mapper.countByExample(example);
		session.close();
		return num;
	}

	public int insert(Student record) {
		SqlSession session=MybatisUtils.getFactory().openSession();
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		int num=mapper.insert(record);
		session.commit();
		session.close();
		return num;
	}

	public int updateByPrimaryKey(Student record) {
		SqlSession session=MybatisUtils.getFactory().openSession();
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		int num=mapper.updateByPrimaryKey(record);
		session.commit();
		session.close();
		return num;
	}

	public boolean deleteIds(String... ids) {
		SqlSession session=MybatisUtils.getFactory().openSession();
		StudentMapper mapper=session.getMapper(StudentMapper.class);
		boolean flag = false;
		if(mapper.deleteIds(ids))
			flag = true;
		session.commit();
		session.close();
		return flag;
	}

}
