package org.tarena.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.tarena.entity.ext.User;

public class UserTest {
	public static String HIBERNATE_COINFIG_FILE = "/hibernate.cfg.xml";
	@Test
	public void saveUserTest() {
		// 读取hibernate.cfg.xml配置文件，获取连接
		/*
		 * //读取hibernate.properties 
		 * Configuration configuration = new Configuration(); 
		 * //读取xml文件 
		 * Configuration c = configuration.configure();
		 */
		//Configuration c = new Configuration().configure("HIBERNATE_COINFIG_FILE");
		Configuration c = new Configuration().configure();
		// 获取连接工厂
		SessionFactory sessionFactory = c.buildSessionFactory();
		Session session = null;
		// 获取连接
		try {
			session = sessionFactory.openSession();
			//获取事务
			session.beginTransaction();
			
			User user = new User();
			user.setName("king");
			user.setPassword("1234");
			session.save(user);
			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			if(session !=null){
				session.close();
			}
		}
	}
}