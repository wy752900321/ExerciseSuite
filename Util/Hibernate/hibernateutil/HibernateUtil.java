package com.wangxin.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * (一)常用
 * ThreadLocal和Struts拦截器的使用
 * 在拦截器中调用closeSession的方法
 * (二)
 * currentSession和openSessionInView
 * 
 */


public class HibernateUtil {
	private static Configuration conf;
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> sessionLocal =
					new ThreadLocal<Session>();
	
	static{
		//	加载hibernate.cfg.xml和hbm.xml映射描述
		conf = new Configuration();
		conf.configure();//默认加载src/hibernate.cfg.xml
		//conf.configure(new File("/abc.cfg.xml"));
		//获取Session工厂
		sessionFactory = 
						conf.buildSessionFactory();
	}
	
	public static Session openSession(){
		Session session = sessionLocal.get();
		//获取一个新的打开的Session
		if(session  == null){
			session = sessionFactory.openSession();
			sessionLocal.set(session);
		}
		return session;
	}
	
	public static void closeSession(){
		Session session = sessionLocal.get();
		sessionLocal.set(null);
		if(session != null){
			session.close();
		}
	}
	
	
}

