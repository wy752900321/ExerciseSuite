package com.tarena.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.OrderDAO;
import com.tarena.dao.impl.HibernateOrderDAO;

public class tes1 {
	public void test1(){
		String[] configs={"applicationContext.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(configs);
		
		OrderDAO orderDAO = new HibernateOrderDAO();
	}
}
