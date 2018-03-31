package com.tarena.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.tarena.pojo.ext.User;
import com.tarena.util.HibernateSessionFactory;

public class TestHQL {

	//@Test
	//查询数据表的某一列字段
	public void test1(){
		//SQL select nickname from d_user
		String hql="select nickname from User where nickname<>''";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		//返回的list中，每个元素是nickname类型
		List<String> list = query.list();
		for(String s:list){
			System.out.println(s);
		}
		HibernateSessionFactory.closeSession();
		
	}
	//@Test
	public void test2(){
		//SQL select id,nickname form d_user
		String hql = "select id,nickname from User where nickname<>''";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		//返回的list中，每个元素是Object[]大小是2
		//Object[0]是id值，Object[1]是nickname值
		List<Object[]> list = query.list();
		for(Object[] obj:list){
			System.out.println(obj[0]+" "+obj[1]);
		}
		HibernateSessionFactory.closeSession();
	}
	//@Test
	//查询数据表的所有字段
	public void test3(){
		//SQL select * from d_user
		String hql = "select user from User user where user.nickname<>''";
//		Stringk hql = "from User where nickname<>''";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		//返回的list中，每个元素是User
		List<User> list = query.list();
		for(User obj : list){
			System.out.println(obj.getId()+" "+obj.getNickname()+" "+obj.getEmail());
		}
		HibernateSessionFactory.closeSession();
	}
	//@Test
	//查询结果是一行一列
	public void test4(){
		//sQL select count(*) from d_user
		String hql = "select count(*) from User";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		//返回的list中，list中包含一个元素
		//元素类型3.2版本是Long,3.1版本是Integer
		List<Object> list = query.list();
		for(Object obj:list){
			System.out.println(obj.getClass().getName());
			System.out.println(obj);
		}
		HibernateSessionFactory.closeSession();
	}
	//@Test
	//带参数的查询语句
	public void test5(){
		//SQL select * from d_user where nickname like 'gook%' 
		//String hql = "from User where nickname like ?";
		String hql = "from User where nickname like :name";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		//设置参数，？索引从0开始
		//query.setString(0,"%s%");
		query.setString("name", "%o%");
		List<User> list = query.list();
		for(User obj:list){
			System.out.println(obj.getId()+" "+obj.getNickname()+" "+obj.getEmail());
		}
		HibernateSessionFactory.closeSession();
	}
	//@Test
	//将HQL写入到hbm.xml中
	public void test6(){
		Session session = HibernateSessionFactory.getSession();
		//获取hbm.xml中的HQL
		Query query = session.getNamedQuery("findById");
		//给hql中的：id设置参数值
		query.setInteger("id", 1);
		List<User> list = query.list();
		for(User obj:list){
			System.out.println(obj.getId()+" "+obj.getNickname()+" "+obj.getEmail());
		}
		HibernateSessionFactory.closeSession();
	}
	//分页查询
	@Test
	public void test7(){
		Session session = HibernateSessionFactory.getSession();
		//获取hbm.xml中的HQL
		Query query = session.getNamedQuery("findAll");
		//设置分布查询参数
		//设置抓取记录的起始位置，从0开始
		query.setFirstResult(0);
		//设置最多抓取5个
		query.setMaxResults(5);
		List<User> list = query.list();
		for(User obj:list){
			System.out.println(obj.getId()+" "+obj.getNickname()+" "+obj.getEmail());
		}
		HibernateSessionFactory.closeSession();
	}
}
