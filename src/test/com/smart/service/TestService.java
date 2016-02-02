package com.smart.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.smart.domain.User;
import com.smart.domain.ViewSpace;
import com.smart.service.ViewSpaceService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(
		locations={"classpath:viewSpace.xml"}
)
public class TestService {
	@Autowired
	private ViewSpaceService vss;
	@Autowired
	private UserService us;
	
	@Test
	public void testSave(){
		ViewSpace space = new ViewSpace();
		User user = us.findUserByName("yujuekong");
		System.out.println(user.toString());
//		space.setSpaceName("小张");
//		vss.addViewSpace(space);
	}
}
