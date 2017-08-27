package com.tsunami.mybatisdemo.pagedemo;

import java.util.List;

import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsunami.mybatisdemo.pojo.Student;
import com.tsunami.mybatisdemo.service.StudentService;
import com.tsunami.mybatisdemo.service.impl.StudentServiceImpl;

public class PageTest {
	
	private StudentService service = new StudentServiceImpl();
	
	@Test
	public void selectPage(){
		PageHelper.startPage(2, 5);
		List<Student> list= service.selectByExample(null);
		PageInfo<Student> stulist=new PageInfo<Student>(list);
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println("总记录数："+stulist.getTotal());
		System.out.println("总记页数："+stulist.getPages());
	}

}
