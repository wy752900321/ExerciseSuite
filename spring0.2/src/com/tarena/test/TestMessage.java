package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.bean.MessageBean;

public class TestMessage {
	@Test
	public void test3() {
		// UserAction userAction = new UserAction();//´íÎó
		String[] config = { "applicationContext.xml" };
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		MessageBean msgBean = (MessageBean) ac.getBean("messagebean");
		msgBean.show();
	}
}
