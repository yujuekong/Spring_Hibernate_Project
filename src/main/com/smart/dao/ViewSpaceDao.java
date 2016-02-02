package com.smart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.smart.domain.ViewSpace;

@Repository
public class ViewSpaceDao extends BaseDao<ViewSpace> {
	/**
	 * 根据景区名进行模糊查询
	 */
	public List<ViewSpace> queryByName(String name){
		String hql = "from ViewSpace vs where vs.spaceName like ?";
		name = "%" + name +"%";
		return this.find(hql,name);
	}
	
	/**
	 * 获取用户管理的所有景区 
	 */
	public List<ViewSpace> queryByUserId(int userId){
		String hql = "from ViewSpace vs where vs.userId = ?";
		return this.find(hql, userId);
	}
}
