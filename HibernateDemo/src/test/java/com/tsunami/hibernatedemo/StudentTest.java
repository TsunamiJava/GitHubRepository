package com.tsunami.hibernatedemo;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tsunami.hibernatedemo.entity.Student;
import com.tsunami.hibernatedemo.utils.HibernateUtils;

public class StudentTest {
	
	private Session session;
	private Transaction transaction;
	
	@Before
	public void beginDate(){
		session=HibernateUtils.getSession();
		transaction=session.beginTransaction();
	}
	
	@After
	public void afterDate() {
		transaction.commit();
		HibernateUtils.CloseSession();
	}
	
	@Test
	public void save(){
		Student student=new Student();
		student.setStuName("hibernate");
		student.setStuAge(22);
		student.setStuSex(1);
		student.setStuNum("105");
		student.setStuClass("test");
		student.setStuCreatetime(new Date());
		session.saveOrUpdate(student);
	}
	
	@Test
	public void rollbacktest(){
		Student student=new Student();
		student.setStuName("hibernate");
		student.setStuAge(22);
		student.setStuSex(1);
		student.setStuNum("105");
		student.setStuClass("test");
		student.setStuCreatetime(new Date());
		session.saveOrUpdate(student);
		if (true) {
			transaction.rollback();
		}
	}
	
	@Test
	public void getById() {
		Student student = (Student) session.get(Student.class, 6);
		// 打不到记录会返回null
		System.out.println(student);
	}
	
	@Test
	public void loadById() {
		Student student = (Student) session.load(Student.class, 32);
		// 打不到记录报异常
		System.out.println(student);
	}
	
	@Test
	public void update(){
		Student student=session.get(Student.class, 32);
		student.setStuAge(25);
		student.setStuUpdatetime(new Date());
		session.saveOrUpdate(student);
	}
	
	@Test
	public void selectAll() {
		Query query = session.createQuery("from Student");
		List<Student> list = query.list();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void delete() {
		Student student = (Student) session.get(Student.class, 28);
		session.delete(student);
	}
	
}
