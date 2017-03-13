package util;


import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil2 {
	private static SessionFactory factory;
	static{
		Configuration cfg = new Configuration();
		cfg.configure();
		factory = cfg.buildSessionFactory();
	}
	public static Session getSession(){
		return factory.openSession();
	}
}
