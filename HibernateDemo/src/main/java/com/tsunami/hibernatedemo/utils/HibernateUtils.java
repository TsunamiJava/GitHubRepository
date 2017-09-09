package com.tsunami.hibernatedemo.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
	private static SessionFactory sessionFactory=configuration.buildSessionFactory();
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	public static void CloseSession(){
		getSession().close();
	}
}
