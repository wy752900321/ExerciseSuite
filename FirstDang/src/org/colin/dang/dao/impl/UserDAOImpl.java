package org.colin.dang.dao.impl;

import org.colin.dang.dao.UserDAO;
import org.colin.dang.pojo.User;
import org.colin.dang.util.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOImpl implements UserDAO {
	

	public void save(User user) throws Exception{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}

	public User findByEmail(String email) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User where email=?";
		Query query = session.createQuery(hql);
		query.setString(0, email);
		User user = (User) query.uniqueResult();
		HibernateSessionFactory.closeSession();
		return user;
	}

	public User findByPassWord(String email) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		String hql="from User where email=?";
		Query query=session.createQuery(hql);
		query.setString(0,email);
		User user=(User) query.uniqueResult();
		HibernateSessionFactory.closeSession();
		return user;
	}

	public User findByEmailVerify(String email) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		String hql="from User where email=?";
		Query query=session.createQuery(hql);
		query.setString(0, email);
		User user=(User) query.uniqueResult();
		
	HibernateSessionFactory.closeSession();
		return user;
	}

	public void updateUser(User user) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		HibernateSessionFactory.closeSession();
		
	}
	
}
