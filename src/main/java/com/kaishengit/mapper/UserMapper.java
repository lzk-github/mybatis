package com.kaishengit.mapper;

import java.util.List;

import com.kaishengit.entity.User;

public interface UserMapper {

	User findById(Integer id);

	List<User> findAll();

	void insert(User u);

	void update(User u);

	void delete(Integer id);

	void deleteByIds(List<Integer> idList);
	
	List<User> findAllLoadDept();
}
