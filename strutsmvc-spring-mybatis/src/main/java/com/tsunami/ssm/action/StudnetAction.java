package com.tsunami.ssm.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tsunami.ssm.pojo.Student;
import com.tsunami.ssm.pojo.StudentExample;
import com.tsunami.ssm.service.StudentService;

@SuppressWarnings("serial")
@Controller
public class StudnetAction extends ActionSupport implements ModelDriven<Student>,ServletRequestAware{

	private Student student=new Student();
	@Autowired
	private StudentService studentService;
	private StudentExample studentExample=new StudentExample();
	private HttpServletRequest request;
	private String search;
	private String ids;
	private List<Student> list;
	private String pageNum;
	
	//http://localhost:8080/strutsmvc-spring-mybatis/student!list.action
	public String list() {
		if(pageNum==null)
			pageNum="1";
		//显示数据数量
		int pageSize = 5;
		PageHelper.startPage(Integer.parseInt(pageNum), pageSize);
		if(search!=null){
			list=studentService.selectLikeByName(search);
			PageInfo<Student> pageInfo=new PageInfo<Student>(list); 
			long totalPages = pageInfo.getTotal()/pageSize+((pageInfo.getTotal()%pageSize)>0?1:0);
			request.setAttribute("search",search);
			request.setAttribute("list",list);
			request.setAttribute("totalPages",totalPages);
			request.setAttribute("pageNum",Integer.parseInt(pageNum));
		}else{
			list= studentService.selectByExample(studentExample);
			PageInfo<Student> pageInfo=new PageInfo<Student>(list); 
			long totalPages = pageInfo.getTotal()/pageSize+((pageInfo.getTotal()%pageSize)>0?1:0);
			request.setAttribute("list",list);
			request.setAttribute("totalPages",totalPages);
			request.setAttribute("pageNum",Integer.parseInt(pageNum));
		}
		return SUCCESS;
	}
	
	public String selectbyid(){
		student=studentService.selectByPrimaryKey(Integer.parseInt(ids));
		request.setAttribute("student",student);
		System.out.println(student);
		return INPUT;
	}
	
	//http://localhost:8080/strutsmvc-spring-mybatis/student!addstu.action
	public String addstu(){
		student.setStuCreatetime(new Date());
		studentService.insert(student);
		System.out.println(student);
		return "tolist";
	}
	
	//http://localhost:8080/strutsmvc-spring-mybatis/student!updatestu.action
	public String updatestu(){
		student.setStuUpdatetime(new Date());
		studentService.updateByPrimaryKeySelective(student);
		return "tolist";
	}
	
	//http://localhost:8080/strutsmvc-spring-mybatis/student!deletestu.action
	public String deletestu(){
		studentService.deleteIds(ids);
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
