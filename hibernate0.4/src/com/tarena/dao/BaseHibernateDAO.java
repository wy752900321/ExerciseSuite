package com.tarena.dao;
// default package

import com.tarena.dang.HibernateSessionFactory;
import org.hibernate.Session;

public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	
}