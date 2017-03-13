package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.PersonDAO;
import com.tarena.dao.UserDAO;

public class TestAop {
	
	@Test
	public void test(){
		String[] configs = {"aopContext.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(configs);
		PersonDAO personDao = (PersonDAO)ac.getBean("persondao");
		personDao.delete();
		personDao.save();
		personDao.update();
		personDao.findById();
		System.out.println("---------UserDAO¥¶¿Ì---------- ");
		UserDAO userDao = (UserDAO)ac.getBean("userdao");
		userDao.delete();
		userDao.save();
	}
}
