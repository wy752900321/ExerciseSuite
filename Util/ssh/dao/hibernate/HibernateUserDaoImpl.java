package com.wangxin.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;


import com.wangxin.dao.UserDao;
import com.wangxin.entity.Dept;

public class HibernateUserDaoImpl implements UserDao{
	private HibernateTemplate template;
	public void setSessionFactory(SessionFactory sessionFactory){
		template = new HibernateTemplate(sessionFactory);
	}
	public int count() {
		String hql="select count(*) from Dept";
		List<Integer> list = template.find(hql);
		return list.get(0).intValue();
	}

	public void delete(int id) {
		Dept dept = findById(id);
		template.delete(dept);
	}

	public List<Dept> findAll() {
		String hql="from Dept";
		List<Dept> list = template.find(hql);
		return list;
	}

	public Dept findById(int id) {
		String hql = "from Dept where id=?";
		List<Dept> list = template.find(hql,new Object[]{id});
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	public void save(Dept dept) {
		template.save(dept);
	}

	public void update(Dept dept) {
		template.update(dept);
	}
	
	@SuppressWarnings("unchecked")
	public List<Dept> findPage(final int page, final int size) {//不继承hibernateDaoSupport的写法
		List<Dept> list = (List<Dept>)template.execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				//编写分页查询逻辑
				String hql = "from Dept";
				Query query = session.createQuery(hql);
				query.setFirstResult((page - 1) * size);
				query.setMaxResults(size);
				return query.list();
			}
		});
		return list;
	}
	public List<Dept> findPage1(int page,int size){
		Session session = this.getSession();//继承hibernateDaoSupport的写法
		String hql = "from Dept";
		Query query = session.createQuery(hql);
		query.setFirstResult((page - 1) * size);
		query.setMaxResults(size);
		List<Dept> list = query.list();
		session.close();//重要
		return list;
	}
	
}
