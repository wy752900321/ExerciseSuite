package com.tarena.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.UserDAO;
import com.tarena.entity.User;

public class TestUserDAO {
	// @Test
	public void testDelete() {
		User user = new User();
		user.setId(15);
		String[] configs = { "applicationContext.xml" };
		ApplicationContext ac = new ClassPathXmlApplicationContext(configs);
		UserDAO userDao = (UserDAO) ac.getBean("userDao");
		userDao.delete(user);
	}

	//@Test
	public void testAdd() {
		User user = new User();
		user.setEmail("ssh@163.com");
		user.setNickname("spring");
		user.setUserIntegral(1);
		user.setPassword("111");
		user.setLastLoginTime(System.currentTimeMillis());

		String[] configs = { "applicationContext.xml" };
		ApplicationContext ac = new ClassPathXmlApplicationContext(configs);
		UserDAO userDao = (UserDAO) ac.getBean("userDao");
		userDao.save(user);
	}
	
	//@Test
	public void testFindById(){
		String[] configs = {"applicationContext.xml"};
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(configs);
		UserDAO userDao = 
			(UserDAO)ac.getBean("userDao");
		User user = userDao.findById(20);
		System.out.println(user.getNickname());
		System.out.println(user.getEmail());
	}
	@Test
	public void testFindAll(){
		String[] configs = {"applicationContext.xml"};
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(configs);
		UserDAO userDao = 
			(UserDAO)ac.getBean("userDao");
		List<User> list = userDao.findAll();
		for(User user:list){
			System.out.print(user.getNickname()+" ");
			System.out.println(user.getEmail());
		}
	}
}