package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.action.UserAction3;

public class TestAction3 {
	//@Test
	public void test1(){
//		UserAction userAction = new UserAction();//´íÎó
		String[] config ={"applicationContext.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		UserAction3 userAction3 = (UserAction3) ac.getBean("useraction3");
		userAction3.register();
	}
	@Test
	public void test2(){
//		UserAction userAction = new UserAction();//´íÎó
		String[] config ={"annotationContext.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		UserAction3 userAction3 = (UserAction3) ac.getBean("useraction3");
		System.out.println(userAction3);
		userAction3.register();
	}
}
