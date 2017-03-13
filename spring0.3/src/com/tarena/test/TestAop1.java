package com.tarena.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.DeptDAO;
import com.tarena.dao.UserDAO;

public class TestAop1 {
	@Test
	public void test1(){
		String[] configs={"aopContext1.xml"};
		ApplicationContext ac =new ClassPathXmlApplicationContext(configs);
		UserDAO userDao = (UserDAO)ac.getBean("userdao");
		System.out.println(userDao.getClass().getName());
		userDao.delete();
		userDao.update();
		userDao.findById();
		userDao.save();
		
		DeptDAO deptDao = (DeptDAO)ac.getBean("deptdao");
		deptDao.save();
		deptDao.update();
		deptDao.delete();//触发异常通知
	}
}
