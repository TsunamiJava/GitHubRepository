package com.tsunami.mybatisdemo.utils;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	public static SqlSessionFactory getFactory(){
		String resource="mybatis-config.xml";
		//加载mybatis的配置文件
		InputStream in=MybatisUtils.class.getClassLoader().getResourceAsStream(resource);
		//构建sqlSession工厂
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		return factory;
	}
}
