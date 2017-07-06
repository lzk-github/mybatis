package com.kaishengit.mybatis;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.util.MyBatisUtil;

public class UserMapperTest {

    private Logger logger = LoggerFactory.getLogger(UserMapperTest.class);
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
    public void testUserMapper() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(1);
        user.setAddress("xxxxxxx");
        userMapper.update(user);
        sqlSession.commit();
        logger.debug("{} -> {}", user.getUserName(), user.getPassword());
        sqlSession.close();
    }

    @Test
    public void insertTest() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("张三", "000", "焦作");
        userMapper.insert(user);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void second() {
	    User user = userMapper.findById(1);
	    System.out.println(user);
    }
    @Test
    public void deleteByIds() {

    }

}











