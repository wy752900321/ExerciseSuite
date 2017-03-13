package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.action.UserAction;
import com.tarena.action.UserAction2;

public class TestAction {
	//@Test
	public void test1(){
//		UserAction userAction = new UserAction();//´íÎó
		String[] config ={"applicationContext.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		UserAction userAction = (UserAction) ac.getBean("useraction");
		userAction.register();
	}
	@Test
	public void test2(){
//		UserAction userAction = new UserAction();//´íÎó
		String[] config ={"applicationContext.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		UserAction2 userAction2 = (UserAction2) ac.getBean("useraction2");
		userAction2.register();
	}
}
