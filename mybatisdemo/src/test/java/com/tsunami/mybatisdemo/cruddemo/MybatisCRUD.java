package com.tsunami.mybatisdemo.cruddemo;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.tsunami.mybatisdemo.pojo.Student;
import com.tsunami.mybatisdemo.service.StudentService;
import com.tsunami.mybatisdemo.service.impl.StudentServiceImpl;


public class MybatisCRUD {
	
	private StudentService service = new StudentServiceImpl();
	
	@Test
	public void selectAll(){
		List<Student> list= service.selectByExample(null);
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void selectLike(){
		List<Student> list= service.selectLikeByName("小");
		for (Student student : list) {
			System.out.println(student);
		}
	}

	@Test
	public void selectbyId(){
		Student student=service.selectByPrimaryKey(1);
		System.out.println(student);
	}
	
	@Test
	public void Count(){
		System.out.println(service.countByExample(null));
	}
	
	@Test
	public void insert(){
		Student student=new Student();
		student.setStuName("小明");
		student.setStuAge(23);
		student.setStuSex(1);
		student.setStuNum("101");
		student.setStuClass("网络工程");
		student.setStuCreatetime(new Date());
		student.setStuUpdatetime(new Date());
		System.out.println(service.insert(student));
	}
	
	@Test
	public void update(){
		Student student=service.selectByPrimaryKey(2);
		student.setStuName("小华");
		student.setStuUpdatetime(new Date());
		System.out.println(service.updateByPrimaryKey(student));
	}
	
	@Test
	public void deteleids(){
		System.out.println(service.deleteIds(new String[]{"1","2"}));
	}
}
