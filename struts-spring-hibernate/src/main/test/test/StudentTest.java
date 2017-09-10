package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tsunami.ssh.entity.Student;
import com.tsunami.ssh.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-hibernate.xml", "classpath:spring-tx.xml" })
public class StudentTest {
    
	@Autowired
	private StudentService service;
	
	@Test
	public void instertest(){
		Student student = new Student();
		student.setStu_name("testintestest");
		student.setStu_age(23);
		student.setStu_sex(1);
		student.setStu_num("205");
		student.setStu_class("网民");
		student.setStu_createtime(new Date());
		service.save(student);
	}
	
	@Test
	public void selectliketest(){
		List<Student> students=service.selectlike("test");
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void updatetest(){
		Student student=service.selectbyid(32);
		student.setStu_name("updatetes02t");
		student.setStu_updatetime(new Date());
		service.updateStudent(student);
	}
	
	@Test
	public void deleteTest(){
		Student student=service.selectbyid(33);
		service.deletebyid(student);
	}
	
	@Test
	public void selectbyid(){
		Student student=service.selectbyid(32);
		System.out.println(student);
	}
	
	@Test
	public void list(){
		List<Student> students=service.selectall();
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
