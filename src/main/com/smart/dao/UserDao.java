package com.smart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.smart.domain.User;
@Repository
public class UserDao extends BaseDao<User> {
	
	public User queryUserByName(String username){
		System.out.println("username:" + username);
		User user = null;
		String hql = "from User u where u.username = ? ";
		List<User> list = this.find(hql,username);
		if(list != null && list.size() > 0){
			user = list.get(0);
		}
		return user;
	}
}
