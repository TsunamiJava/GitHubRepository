package com.tsunami.ssm.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tsunami.ssm.pojo.StudentExample;
import com.tsunami.ssm.pojo.Student;
import com.tsunami.ssm.service.StudentService;

//JUnit测试
@RunWith(SpringJUnit4ClassRunner.class)
//获取配置xml文件
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class testCode {
	@Autowired
	private StudentService studentService;
	
	private List<Student> list;
	private StudentExample studentExample=new StudentExample();
	
	@Test
	public void test(){
		System.out.println("test");
		list= studentService.selectByExample(studentExample);
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
