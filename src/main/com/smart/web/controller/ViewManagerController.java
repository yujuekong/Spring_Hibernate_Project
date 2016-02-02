package com.smart.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smart.domain.DTablePageModel;
import com.smart.domain.ViewSpace;
import com.smart.service.ViewSpaceService;

@Controller
@RequestMapping("/viewManager")
public class ViewManagerController extends BaseController{
	@Autowired
	private ViewSpaceService viewSpaceService;
	
	private static final DTablePageModel dpm = new DTablePageModel();
	
	//显示所有景区列表
	@RequestMapping(value="/list")
	public void listViewSpaces(HttpServletRequest request,HttpServletResponse response) throws JSONException, IOException{
		List<ViewSpace> list = viewSpaceService.getAllViewSpace();
//		request.setAttribute("aaData", list);
		dpm.setAaData(list);
		String jsonData = JSONUtil.serialize(dpm);
		PrintWriter pw = response.getWriter();
		pw.write(jsonData);
		pw.flush();
	}
	
	//新增景区
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView addViewSpace(@ModelAttribute("SpringWeb")ViewSpace viewSpace){
		System.out.println(viewSpace.getSpaceName() + "," + viewSpace.getAddress() + "," + viewSpace.getDescription());
		viewSpaceService.addViewSpace(viewSpace);
		return new ModelAndView("viewSpaceList");
	} 
	
	
}
