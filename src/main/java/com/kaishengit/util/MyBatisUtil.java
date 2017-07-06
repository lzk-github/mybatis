package com.kaishengit.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	private static SqlSessionFactory sqlSessionFactory = getInstance();

	private static SqlSessionFactory getInstance() {
		
		SqlSessionFactory sqlSessionFactory = null;
		try {
			//1.加载配置
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			//2.创建sqlsessionFactory对象
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		} catch (Exception e) {
			throw new RuntimeException("初始化sqlsessionfactory对象失败",e);
		}
		return sqlSessionFactory;
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
