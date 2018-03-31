package com.tarena.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tarena.dao.UserDAO;
import com.tarena.entity.User;

public class HibernateUserDAO2 extends HibernateDaoSupport implements UserDAO {

	//取消了HibernateTemplate定义
	//取消了setSessionFactory()定义
	private HibernateTemplate template;
	
	// 注入一个sessionFactory对象
	/*public void setSessionFactory(SessionFactory sessionFactory) {
		template = new HibernateTemplate(sessionFactory);
	}*/

	@SuppressWarnings("unchecked")
	public int count() {
		String hql = "select count(*) from User";
		List list = this.getHibernateTemplate().find(hql);
		int c = Integer.parseInt(list.get(0).toString());
		return c;
	}

	public void delete(User user) {
		this.getHibernateTemplate().delete(user);

	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		String hql = "from User";
		List<User> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	public User findById(int id) {
		// User user=(User)template.get(User.class,id);
		// return null;
		// 测试带参数的使用情况
		String hql = "from User where id=?";
		Object[] params = { id };
		List<User> list = this.getHibernateTemplate().find(hql, params);
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public void save(User user) {
		this.getHibernateTemplate().save(user);

	}

	public void update(User user) {
		this.getHibernateTemplate().update(user);

	}

	@SuppressWarnings("unchecked")
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
