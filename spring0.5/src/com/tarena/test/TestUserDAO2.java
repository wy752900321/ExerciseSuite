package com.tarena.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.UserDAO;
import com.tarena.entity.User;
/**
 * extends HibernateDaoSupport版本测试
 * 取消了HibernateTemplate定义
	取消了setSessionFactory()定义
 */
public class TestUserDAO2 {
	 @Test
	public void testDelete() {
		User user = new User();
		user.setId(24);
		String[] configs = { "applicationContext.xml" };
		ApplicationContext ac = new ClassPathXmlApplicationContext(configs);
		UserDAO userDao = (UserDAO) ac.getBean("userDao2");
		userDao.delete(user);
	}

	//@Test
	public void testAdd() {
		User user = new User();
		user.setEmail("struts2@163.com");
		user.setNickname("spring");
		user.setUserIntegral(1);
		user.setPassword("111");
		user.setLastLoginTime(System.currentTimeMillis());

		String[] configs = { "applicationContext.xml" };
		ApplicationContext ac = new ClassPathXmlApplicationContext(configs);
		UserDAO userDao = (UserDAO) ac.getBean("userDao2");
		userDao.save(user);
	}
	
	//@Test
	public void testFindById(){
		String[] configs = {"applicationContext.xml"};
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(configs);
		UserDAO userDao = 
			(UserDAO)ac.getBean("userDao2");
		User user = userDao.findById(20);
		System.out.println(user.getNickname());
		System.out.println(user.getEmail());
	}
	//@Test
	public void testFindAll(){
		String[] configs = {"applicationContext.xml"};
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(configs);
		UserDAO userDao = 
			(UserDAO)ac.getBean("userDao2");
		List<User> list = userDao.findAll();
		for(User user:list){
			System.out.print(user.getNickname()+" ");
			System.out.println(user.getEmail());
		}
	}
}