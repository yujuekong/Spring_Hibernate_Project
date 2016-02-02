package com.smart.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.UserDao;
import com.smart.domain.User;
@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	/**
	 * 根据用户名查找用户对象
	 * @param username
	 * @return
	 */
	public User findUserByName(String username){
		return userDao.queryUserByName(username);
	}
	/**
	 * 更新用户
	 * @param user
	 */
	public void updateUser(User user){
		userDao.update(user);
	}
	
	
}
