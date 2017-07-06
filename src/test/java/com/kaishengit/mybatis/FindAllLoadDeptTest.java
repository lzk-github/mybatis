package com.kaishengit.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.util.MyBatisUtil;

public class FindAllLoadDeptTest {
	private SqlSession sqlSession;
	private UserMapper userMapper;
	
	
	@Before
	public void before() {
		sqlSession = MyBatisUtil.getSqlSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
	}
	@After
	public void after() {
		sqlSession.close();
	}
	
	@Test
	public void test() {
		List<User> list = userMapper.findAllLoadDept();
		for(User u : list) {
			System.out.println(u.getUserName() + "->" + u.getDept().getDeptName());
		}
	}

}
