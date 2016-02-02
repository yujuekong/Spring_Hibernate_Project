package com.smart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smart.dao.CommentLogDao;
import com.smart.dao.ViewPointDao;
import com.smart.dao.ViewSpaceDao;
import com.smart.domain.CommentLog;
import com.smart.domain.ViewSpace;

@Service
public class ViewSpaceService {
	@Autowired
	private ViewSpaceDao viewSpaceDao;
	@Autowired
	private ViewPointDao viewPointDao;
	@Autowired
	private CommentLogDao commentLogDao;
	/**
	 * 增加景区
	 * @param viewSpace
	 */
	public void addViewSpace(ViewSpace viewSpace){
		viewSpaceDao.save(viewSpace);
	}
	/**
	 * 删除景区
	 * @param spaceId
	 */
	public void deleteViewSpace(int spaceId){
		//删除景区评论
		commentLogDao.removeLogBySpaceId(spaceId);
		ViewSpace vs = viewSpaceDao.load(spaceId);
		viewSpaceDao.remove(vs);
	}
	/**
	 * 更新景区信息
	 * @param viewSpace
	 */
	public void updateViewSpace(ViewSpace viewSpace){
		viewSpaceDao.update(viewSpace);
	}
	/**
	 * 根据景区姓名模糊查询
	 * @param spaceName
	 * @return
	 */
	public List<ViewSpace> findBySpaceName(String spaceName){
		return viewSpaceDao.queryByName(spaceName);
	}
	/**
	 * 获取某个景区管理员管辖的所有景区
	 */
	public List<ViewSpace> findByUserId(int userId){
		return viewSpaceDao.queryByUserId(userId);
	}
	/**
	 * 获取所有景区
	 * @return
	 */
	public List<ViewSpace> getAllViewSpace(){
		return viewSpaceDao.loadAll();
	}
	
	/**
	 * 获取某个景区
	 */
	public ViewSpace getViewSpace(int spaceId){
		return viewSpaceDao.get(spaceId);
	}
	/**
	 * 对景区进行评论，同时更新景区评论值
	 * @param commentLog
	 */
	public void addCommentLog(CommentLog commentLog){
		ViewSpace viewSpace = viewSpaceDao.load(commentLog.getSpaceId());
		boolean commented = commentLogDao.isIpCommented(viewSpace.getSpaceId(), commentLog.getIp());
		if(commented){
			throw new RuntimeException("这个IP已经对景区进行了评论");
		}
		switch(commentLog.getCommentType()){
		case CommentLog.WANT_TO_GO:
			viewSpace.setWantNum(viewSpace.getWantNum() + 1);
			break;
		case CommentLog.HAVE_BEAN_TO:
			viewSpace.setBeenNum(viewSpace.getBeenNum() + 1);
			break;
		case CommentLog.DONT_WANT_TO:
			viewSpace.setNotwantNum(viewSpace.getNotwantNum() + 1);
			break;
		default:
			throw new RuntimeException("评论类型不正确！");
		}
		commentLogDao.save(commentLog);
		viewSpaceDao.update(viewSpace);
	}
	
}
