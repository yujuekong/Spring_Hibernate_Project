package com.smart.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.smart.dao.ViewSpaceDao;
import com.smart.domain.User;
import com.smart.domain.ViewSpace;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(
		locations={"classpath:viewspace-dao.xml"}
)
public class ViewSpaceDaoTest {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testSave(){
		User user = new User();
//		ViewSpaceDao dao = new ViewSpaceDao();
//		ViewSpace vs = new ViewSpace();
		user.setUsername("yujuekong");
		user.setPassword("admin");
		userDao.save(user);
	}
}
