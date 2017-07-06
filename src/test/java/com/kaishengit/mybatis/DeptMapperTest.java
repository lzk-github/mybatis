package com.kaishengit.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.kaishengit.entity.Dept;
import com.kaishengit.mapper.DeptMapper;
import com.kaishengit.util.MyBatisUtil;

public class DeptMapperTest {

	
	@Test
	public void test() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
		Dept dept = deptMapper.findByIdLoadUser(1);
		System.out.println(dept.getUserList());
	}
}
