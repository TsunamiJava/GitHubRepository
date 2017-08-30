package com.tsunami.smm.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsunami.smm.pojo.Student;
import com.tsunami.smm.service.StudentService;


//JUnit测试
@RunWith(SpringJUnit4ClassRunner.class)
//获取配置xml文件
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class mybatistest {

	@Autowired
	private StudentService service;
	
	@Test
	public void test(){
		PageHelper.startPage(1, 5);
		List<Student> list= service.selectByExample(null);
		PageInfo<Student> stulist=new PageInfo<Student>(list);
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println(stulist.getTotal());
	}
}
