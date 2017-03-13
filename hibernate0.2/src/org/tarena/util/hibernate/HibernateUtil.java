package org.tarena.util.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static String HIBERNATE_CONFIG_FILE = "/hibernate.cfg.xml";

	public static SessionFactory sessionFactory;

	private HibernateUtil() {
	}

	static {
		Configuration c = new Configuration().configure(HIBERNATE_CONFIG_FILE);
		sessionFactory = c.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void close(Session session) {
		if (session != null) {
			session.close();
		}
	}

}
