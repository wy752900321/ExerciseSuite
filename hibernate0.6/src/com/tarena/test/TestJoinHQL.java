package com.tarena.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.tarena.util.HibernateSessionFactory;

public class TestJoinHQL {
	
	//@Test
	//显示收货地址id,收货人,用户id,用户昵称
	public void test1(){
		StringBuffer hql = new StringBuffer();
		hql.append("	SELECT ");
		hql.append("		address.id,");
		hql.append("		address.receiveName,");
		hql.append("		address.user.id,");
		hql.append("	    user.nickname");
		hql.append("	FROM ");
		hql.append("		Address address,");
		hql.append("		User user");
		hql.append("	WHERE ");
		hql.append("		address.user.id = user.id");
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql.toString());
		List<Object[]> list = query.list();
		for(Object[] obj:list){
			System.out.println(obj[0]+" "+obj[1]+" "+obj[2]+" "+obj[3]);
		}
		HibernateSessionFactory.closeSession();
	}
	
	//功能等价于test1
	//@Test
	public void test2(){
		StringBuffer hql = new StringBuffer();
		hql.append("	SELECT ");
		hql.append("		address.id,");
		hql.append("		address.receiveName,");
		hql.append("		address.user.id,");
		hql.append("	    address.user.nickname,");
		hql.append("	    address.user.email");
		hql.append("	FROM ");
		hql.append("		Address address");
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql.toString());
		List<Object[]> list = query.list();
		for (Object[] obj : list) {
			System.out.println(obj[0] + " " + obj[1] + " " + obj[2] + " "
					+ obj[3] + " " + obj[4]);
		}
		HibernateSessionFactory.closeSession();
	}
	
	@Test
//	功能等价于test1
	public void test3(){
		StringBuffer hql = new StringBuffer();
		hql.append("	SELECT ");
		hql.append("		address.id,");
		hql.append("		address.receiveName,");
		hql.append("		address.user.id,");
		hql.append("	    user.nickname");
		hql.append("	FROM ");
		hql.append("		Address address ");
		hql.append("		inner join address.user user");
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql.toString());
		List<Object[]> list = query.list();
		for (Object[] obj : list) {
			System.out.println(obj[0] + " " + obj[1] + " " + obj[2] + " "
					+ obj[3]);
		}
		HibernateSessionFactory.closeSession();
	}
	
	@Test
	//显示用户id,用户昵称,收货地址数量
	public void test4(){
		StringBuffer hql = new StringBuffer();
		hql.append("	select ");
		hql.append("		user.id, ");
		hql.append("		user.nickname,  ");
		hql.append("	    count(address.id) ");
		hql.append("	from  ");
		hql.append("		User user  ");
		hql.append("	left outer join  user.address address ");
		hql.append("	group by  ");
		hql.append("		user.id ");
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql.toString());
		List<Object[]> list = query.list();
		for (Object[] obj : list) {
			System.out.println(obj[0]+" "+obj[1]+" "+obj[2]);
		}
		HibernateSessionFactory.closeSession();
	}
	}
