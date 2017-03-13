package com.tarena.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.tarena.dao.UserDAO;
import com.tarena.entity.User;

public class HibernateUserDAO implements UserDAO {

	private HibernateTemplate template;

	// 注入一个sessionFactory对象
	public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public int count() {
		String hql = "select count(*) from User";
		List list = template.find(hql);
		int c = Integer.parseInt(list.get(0).toString());
		return c;
	}

	public void delete(User user) {
		template.delete(user);

	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		String hql = "from User";
		List<User> list = template.find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public User findById(int id) {
		// User user=(User)template.get(User.class,id);
		// return null;
		// 测试带参数的使用情况
		String hql = "from User where id=?";
		Object[] params = { id };
		List<User> list = template.find(hql, params);
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public void save(User user) {
		template.save(user);

	}

	public void update(User user) {
		template.update(user);

	}

	@SuppressWarnings("unchecked")
	//提示：在Spring整合Hibernate后，DAO如何获取和使用Session对象
	//推荐使用doInHibernate(Session session)方式
	public List<User> findPage(final int page, final int pageSize) {
		//可以得到session，不推荐使用,如果使用必须显式的关闭。不推荐
		//template.getSessionFactory().openSession();
		List<User> list=
			(List)template.execute(
				new HibernateCallback(){
			public Object doInHibernate(Session session)
				throws HibernateException,SQLException{
				//使用session
				String hql="from User";
				Query query = session.createQuery(hql);
				int begin = (page-1)*pageSize;
				query.setFirstResult(begin);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
		return list;
	}

}
