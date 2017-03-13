package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.User;
import util.HibernateUtil;
import dao.UserDAO;

public class UserDAOHibernateImpl implements UserDAO {

	public User findByUsername(String username) {
		// FIXME Auto-generated method stub
		User user = null;
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from User u where u.username=:name").setString("name", username);
		user = (User) query.uniqueResult();
		session.close();
		return user;
	}

	public List<User> list() {
		// FIXME Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from User u");
		List<User> users = query.list();
		session.close();
		return users;
	}

	public void save(User user) {
		// FIXME Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}

	public User findById(Long id) {
		// FIXME Auto-generated method stub
		User user = null;
		Session session = HibernateUtil.getSession();
		user  = (User) session.load(User.class, id);
		session.close();
		return user;
	}

}
