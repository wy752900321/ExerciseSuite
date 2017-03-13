package com.tarena.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.tarena.entity.ext.User;
import com.tarena.util.hibernate.HibernateUtil;

public class UserDaoImpl {

	public int saveUser(User user) {
		int userid = 0;
		Session session = null;
		// 获取连接
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			// 获取事务
			session.beginTransaction();

			userid = (Integer) session.save(user);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
		return userid;
	}

	// 根据ID查询
	public User findUserById(User u) {
		User user = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			user = (User) session.get(User.class, u.getUserId());
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
		return user;
	}
	//查询所有用户信息
	@SuppressWarnings("unchecked")
	public List<User> findAllUser(){
		List<User> users = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			users=session.createCriteria(User.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.close(session);
		}
		return users;	
	}
	//修改用户信息
	public void updateUserById(User user){
		Session session = null;
		try {
			session=HibernateUtil.getSessionFactory().openSession();
		    session.beginTransaction();
		    session.update(user);
		    session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtil.close(session);
		}
	}
	
//	修改或者添加用户信息
	public void updateOrSaveUserById(User user){
		Session session = null;
		try {
			session=HibernateUtil.getSessionFactory().openSession();
		    session.beginTransaction();
		    session.saveOrUpdate(user);
		    session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtil.close(session);
		}
	}
	//删除
	public void deleteUserById(User user){
		Session session = null;
		try {
			session=HibernateUtil.getSessionFactory().openSession();
		    session.beginTransaction();
		    session.delete(user);
		    session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			HibernateUtil.close(session);
		}
	}
	
}
