package com.smart.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smart.domain.CommonConst;
/**
 * 登陆权限过滤器（未登录的用户无法查看项目页面）
 * @author CA
 *
 */
public class ViewSpaceFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String path = req.getContextPath();
		Object obj = req.getAttribute(CommonConst.USER_CONTEXT);
		if(obj == null){
			res.sendRedirect( path + "/index.jsp");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
