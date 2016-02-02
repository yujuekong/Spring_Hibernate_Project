package com.smart.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;

import com.smart.domain.CommonConst;
import com.smart.domain.User;
/**
 * baseController
 * @author CA
 * 
 */
public class BaseController {
	/**
	 * 将用户保存到Session中
	 * @param request
	 * @param user
	 */
	protected void setSessionUser(HttpServletRequest request,User user){
		request.getSession().setAttribute(CommonConst.USER_CONTEXT, user);
	}
	/**
	 * 获取保存到Session中的用户对象
	 * @param request
	 * @return
	 */
	protected User getSessionUser(HttpServletRequest request){
		return (User) request.getSession().getAttribute(CommonConst.USER_CONTEXT);
	}
	/**
	 * 获取基于应用程序的url绝对路径
	 * @param request
	 * @param url
	 * @return
	 */
	public final String getAPPbaseUrl(HttpServletRequest request,String url){
		Assert.hasLength(url,"url不能为空");
		Assert.isTrue(url.startsWith("/"), "必须以/打头");
		return request.getContextPath() + url;
	}
	
	
}
