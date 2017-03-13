package com.tarena.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tarena.entity.Dept;

public class HibernateDeptDAO1 
						extends HibernateDaoSupport 
						implements DeptDAO{
	
	public int count() {
		String hql = "select count(*) from Dept";
		List<Long> list = 
			this.getHibernateTemplate().find(hql);
		return list.get(0).intValue();
	}

	public void deleteById(int id) {
		Dept dept = findById(id);
		this.getHibernateTemplate().delete(dept);
		
	}

	public List<Dept> findAll() {
		String hql = "from Dept";
		List<Dept> list =
			this.getHibernateTemplate().find(hql);
		return list;
	}

	public Dept findById(int id) {
		String hql = "from Dept where id=?";
		List<Dept> list = 
			this.getHibernateTemplate()
			.find(hql,new Object[]{id});
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	public void save(Dept dept) {
		this.getHibernateTemplate().save(dept);
		
	}

	public void update(Dept dept) {
		this.getHibernateTemplate().update(dept);
	}

	public List<Dept> findPage(int page, int size) {
		Session session = this.getSession();
		String hql = "from Dept";
		Query query = session.createQuery(hql);
		query.setFirstResult((page-1)*size);
		query.setMaxResults(size);
		List<Dept> list = query.list();
		session.close();//живЊ
		return list;
	}

}
