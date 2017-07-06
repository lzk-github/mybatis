package com.kaishengit.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kaishengit.entity.User;
import com.kaishengit.util.MyBatisUtil;

public class MybatisTest {

	private Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	
	@Test
	public void firstTest() throws Exception {
	
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",1);
		System.out.println(user);
		sqlSession.commit();
		//5.关闭sqlsession
		sqlSession.close();
	}
}
