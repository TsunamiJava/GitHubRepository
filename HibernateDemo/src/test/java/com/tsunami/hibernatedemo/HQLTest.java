package com.tsunami.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;

import com.tsunami.hibernatedemo.entity.Student;

public class HQLTest {
	
	private SessionFactory factory;
	
	@Before
	public void init(){
		Configuration configuration =new Configuration();
		configuration.configure("hibernate.cfg.xml");
		factory=configuration.buildSessionFactory();
	}
	
	/**
	 * 简单查询
	 */
	@Test
	public void select(){
		Session session=factory.openSession();
		Query query=session.createQuery("from Student s");
		List<Student> students=query.list();
		for (Student student : students) {
			System.out.println(student);
		}
		session.close();
	}
	
	/**
	 * 排序查询
	 */
	@Test
	public void orderby(){
		Session session=factory.openSession();
		Query query=session.createQuery("from Student s order by s.stuId desc");
		List<Student> students=query.list();
		for (Student student : students) {
			System.out.println(student);
		}
		session.close();
	}
	
	/**
	 * 分页查询
	 */
	@Test
	public void page(){
		Session session=factory.openSession();
		Query query=session.createQuery("from Student s order by s.stuId ");
		query.setFirstResult(1);
		query.setMaxResults(5);
		List<Student> students=query.list();
		for (Student student : students) {
			System.out.println(student);
		}
		session.close();
	}
	
	/**
	 * 投影查询
	 */
	@Test
	public void select1(){
		Session session=factory.openSession();
		Query query=session.createQuery("select stuName,stuAge from Student ");
		List<Object[]> sList=query.list();
		for (Object[] objects : sList) {
			System.out.println(objects[0]+ "-->" +objects[1]);
		}
		session.close();
	}
	
	/**
	 * 分组查询
	 */
	@Test
	public void groupby(){
		Session session=factory.openSession();
		Query query=session.createQuery("select stuName,count(stuId),max(stuId) from Student group by stuName ");
		List<Object[]> sList=query.list();
		for (Object[] objects : sList) {
			System.out.println(objects[0]+"-->"+objects[1]+"-->"+objects[2]);
		}
		session.close();
	}
	
	@Test
	public void getNamedQuery(){
		Session session = factory.openSession();
		//获取Student.hbm.xml中的配置
		Query query = session.getNamedQuery("findUsers");
		List<Student> users = query.list();
		for (Student user : users) {
			System.out.println(user);
		}
		session.close();
	}
	
	
	/**
	 * 绑定参数
	 */
	@Test
	public void parameter(){
		Session session=factory.openSession();
		Query query=session.createQuery("from Student s where s.stuName=:name and s.stuAge=:age");
		query.setString("name", "HQLTest");
		query.setString("age", "23");
		List<Student> students=query.list();
		for (Student student : students) {
			System.out.println(student);
		}
		session.close();
	}

}
