package com.tsunami.springhibernate.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.tsunami.springhibernate.dao.StudentDAO;
import com.tsunami.springhibernate.entity.Student;

@Repository
public class StudentDAOImpl extends HibernateDaoSupport implements StudentDAO {

	@Autowired
	public final void setSuperSessionFactory(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> selectall(Class clazz) {
		return (List<Student>) this.getHibernateTemplate().find("from "+clazz.getName());
	}

	public Student selectbyid(int id) {
		return (Student) this.getHibernateTemplate().get(Student.class, id);
	}

	public void save(Student student) {
		this.getHibernateTemplate().save(student);
	}

	public void updateStudent(Student student) {
		this.getHibernateTemplate().update(student);
	}

	public void deletebyid(Student student) {
		this.getHibernateTemplate().delete(student);
	}


}
