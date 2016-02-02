package com.smart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.smart.domain.CommentLog;
@Repository
public class CommentLogDao extends BaseDao<CommentLog>{
	/**
	 * 删除景区评论
	 * @param spaceId
	 */
	public void removeLogBySpaceId(int spaceId){
		String hql = "select * from CommentLog cl where cl.spaceId = ?";
		List<CommentLog> list = this.find(hql, spaceId);
		if(list != null && list.size() > 0){
			for(int i = 0;i<list.size();i++){
				this.remove(list.get(i));
			}
		}
	}
	/**
	 * 判断是否重复评论
	 * @param spaceId
	 * @param ip
	 * @return
	 */
	public boolean isIpCommented(int spaceId,String ip){
		boolean result = false;
		String hql = "select * from CommentLog cl where cl.spaceId = ? and cl.ip = ?";
		List<CommentLog> list = this.find(hql, new Object[]{spaceId,ip});
		if(list != null && list.size() > 0){
			result = true;
		}
		return result;
	}
}
