package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.action.UserAction3;

public class TestComponentScan {
	@Test
	public void test1() {
		String[] configs = { "annotationContext.xml" };
		ApplicationContext ac = new ClassPathXmlApplicationContext(configs);
		// UserDAO userDao =
		// (UserDAO)ac.getBean("userdao");
		// userDao.delete();
		UserAction3 userAction3 = (UserAction3)ac.getBean("useraction3");
		System.out.println(userAction3);
		userAction3.register();
	}
}