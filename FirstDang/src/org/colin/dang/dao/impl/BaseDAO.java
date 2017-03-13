package org.colin.dang.dao.impl;

import org.colin.dang.util.HibernateSessionFactory;
import org.hibernate.Session;

public class BaseDAO {
  public Session getSession(){
	  return HibernateSessionFactory.getSession();
  }
  public void closeSession(){
	  HibernateSessionFactory.closeSession();
  }
}
