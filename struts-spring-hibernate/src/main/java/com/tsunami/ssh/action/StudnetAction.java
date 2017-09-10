package com.tsunami.ssh.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tsunami.ssh.entity.Student;
import com.tsunami.ssh.service.StudentService;

@SuppressWarnings("serial")
@Controller
public class StudnetAction extends ActionSupport implements ModelDriven<Student>,ServletRequestAware{

	private Student student=new Student();
	@Autowired
	private StudentService studentService;
	private HttpServletRequest request;
	private String search;
	private String ids;
	private List<Student> list;
	private String pageNum;
	
	//http://localhost:8080/struts-spring-hibernate/student!list.action
	public String list(){
		if(search!=null){
			list=studentService.selectlike(search);
		}else{
			list= studentService.selectall();
		}
		return SUCCESS;
	}
	
	public String selectbyid(){
		student=studentService.selectbyid(Integer.parseInt(ids));
		request.setAttribute("student",student);
		return INPUT;
	}
	
	//http://localhost:8080/struts-spring-hibernate/student!addstu.action
	public String addstu(){
		student.setStu_createtime(new Date());
		studentService.save(student);
		System.out.println(student);
		return "tolist";
	}
	
	//http://localhost:8080/struts-spring-hibernate/student!updatestu.action
	public String updatestu(){
		student.setStu_updatetime(new Date());
		studentService.updateStudent(student);
		return "tolist";
	}
	
	//http://localhost:8080/struts-spring-hibernate/student!deletestu.action
	public String deletestu(){
		student=studentService.selectbyid(Integer.parseInt(ids));
		studentService.deletebyid(student);
		return "tolist";
	}
	

	public Student getModel() {
		// TODO Auto-generated method stub
		return student;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	
	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		return "success";
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	
}
