package com.smart.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smart.domain.CommonConst;
import com.smart.domain.User;
import com.smart.service.UserService;
import com.smart.util.DateUtil;

/**
 * 登陆和注销Controller
 * @author CA
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	private Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/do")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		logger.info("username:" + username + ",password:" + password);
		User user = userService.findUserByName(username);
		if(user == null){
			request.setAttribute("errorMsg", "用户名不存在!");
			return new ModelAndView("forward:/index.jsp");
		}
		else if(!password.equals(user.getPassword())){
			request.setAttribute("errorMsg", "用户密码不正确!");
			return new ModelAndView("forward:/index.jsp");
		}
		else{
			user.setLoginIp(request.getLocalAddr());
            user.setLoginTime(DateUtil.getDateY_M_DH_M_SS());
            userService.updateUser(user);
			this.setSessionUser(request,user); //将用户对象写入到Session中
			return new ModelAndView("viewSpaceList");
		}
	}
	/**
	 * 注销用户
	 * @param session
	 * @return
	 */
	@RequestMapping("/doLogout")
	public String logout(HttpSession session){
		session.removeAttribute(CommonConst.USER_CONTEXT);
		return "forward:/index.jsp";
	}
		
}
