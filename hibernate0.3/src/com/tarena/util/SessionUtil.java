package com.tarena.util;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class SessionUtil {
	private static SessionFactory sessionbFactory;
	// 负责将connection与当前执行线程绑定
	private static ThreadLocal<Session> sessionLocal = new ThreadLocal<Session>();
	static{
		Configuration conf = new Configuration();
		//默认加载src下的hibernate.cfg.xml
		conf.configure();
		//获取Session对象工厂
		sessionbFactory = conf.buildSessionFactory();
	}
	public static Session getSession() throws SQLException {
		//如果当前线程前面创建过session，则将session返回
		Session session = sessionLocal.get();
		if (session == null) {
			session = sessionbFactory.openSession();
			sessionLocal.set(session);
		}
		return session;
	}
	public static void closeSession() throws SQLException {
		Session session = sessionLocal.get();
		sessionLocal.set(null);
		if (session != null) {
			session.close();
		}
	}
	public static void main(String[] args) throws Exception {
		Session session = getSession();
		System.out.println(session.hashCode());
		Session session1 = getSession();
		System.out.println(session1.hashCode());
		
		
	}
}
