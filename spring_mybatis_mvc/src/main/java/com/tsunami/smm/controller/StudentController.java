package com.tsunami.smm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsunami.smm.pojo.Student;
import com.tsunami.smm.pojo.StudentExample;
import com.tsunami.smm.service.StudentService;


@Controller
//获取配置xml文件
@ContextConfiguration(locations={"classpath:spring-config.xml"})
public class StudentController{
	
	@Autowired
	private StudentService service;
	private StudentExample studentExample=new StudentExample();
	
	//http://localhost:8080/spring_mybatis_mvc/showlist.do
	@RequestMapping(value="/showlist")
	public String selectAll(@RequestParam(defaultValue = "1") String pageNum,String search,Model model){
		if(pageNum==null){
			pageNum="1";
		}
		//显示数据数量
		int pageSize = 5;
		PageHelper.startPage(Integer.parseInt(pageNum), pageSize);
		//判断search是否为空
		if(search!=null){
			List<Student> students=service.selectLikeByName(search);
			PageInfo<Student> pageInfo=new PageInfo<Student>(students);
			long totalPages = pageInfo.getTotal()/pageSize+((pageInfo.getTotal()%pageSize)>0?1:0);
			model.addAttribute("search",search);
			model.addAttribute("dates",students);
			model.addAttribute("totalPages",totalPages);
			model.addAttribute("pageNum",Integer.parseInt(pageNum));
			System.out.println(search);
		}else{
			List<Student> students = service.selectByExample(studentExample);
			PageInfo<Student> pageInfo=new PageInfo<Student>(students);	
			long totalPages = pageInfo.getTotal()/pageSize+((pageInfo.getTotal()%pageSize)>0?1:0);
			model.addAttribute("dates",students);
			model.addAttribute("totalPages",totalPages);
			model.addAttribute("pageNum",Integer.parseInt(pageNum));
		}
		return "index.jsp";
		
	}
	
	//http://localhost:8080/spring_mybatis_mvc/addstu.do
	@RequestMapping(value="/addstu")
	public String addStu(Student student){
		student.setStuCreatetime(new Date());
		service.insert(student);
		return "showlist.do";
	}
	
	//http://localhost:8080/spring_mybatis_mvc/deletestu.do
	@RequestMapping(value="/deletestu")
	public String deleteStu(String ids){
		service.deleteIds(ids);
		return "showlist.do";
	}
	
	//http://localhost:8080/spring_mybatis_mvc/Selectstuids.do
	@RequestMapping(value="/selectstuids")
	public String SelectStuids(String ids,Model model){
	    Student student=service.selectByPrimaryKey(Integer.parseInt(ids));
	    model.addAttribute("student",student);
		return "update.jsp";
	}
	
	//http://localhost:8080/spring_mybatis_mvc/updatestu.do
	@RequestMapping(value="/updatestu")
	public String updateStu(Student student){
		student.setStuUpdatetime(new Date());
		service.updateByExample(student);
		return "showlist.do";
	}
	
	
}
