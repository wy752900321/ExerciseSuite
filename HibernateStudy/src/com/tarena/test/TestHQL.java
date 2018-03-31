package com.tarena.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.tarena.pojo.ext.User;
import com.tarena.util.HibernateSessionFactory;

public class TestHQL {

	//@Test
	//��ѯ���ݱ��ĳһ���ֶ�
	public void test1(){
		//SQL select nickname from d_user
		String hql="select nickname from User where nickname<>''";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		//���ص�list�У�ÿ��Ԫ����nickname����
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
		//���ص�list�У�ÿ��Ԫ����Object[]��С��2
		//Object[0]��idֵ��Object[1]��nicknameֵ
		List<Object[]> list = query.list();
		for(Object[] obj:list){
			System.out.println(obj[0]+" "+obj[1]);
		}
		HibernateSessionFactory.closeSession();
	}
	//@Test
	//��ѯ���ݱ�������ֶ�
	public void test3(){
		//SQL select * from d_user
		String hql = "select user from User user where user.nickname<>''";
//		Stringk hql = "from User where nickname<>''";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		//���ص�list�У�ÿ��Ԫ����User
		List<User> list = query.list();
		for(User obj : list){
			System.out.println(obj.getId()+" "+obj.getNickname()+" "+obj.getEmail());
		}
		HibernateSessionFactory.closeSession();
	}
	//@Test
	//��ѯ�����һ��һ��
	public void test4(){
		//sQL select count(*) from d_user
		String hql = "select count(*) from User";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		//���ص�list�У�list�а���һ��Ԫ��
		//Ԫ������3.2�汾��Long,3.1�汾��Integer
		List<Object> list = query.list();
		for(Object obj:list){
			System.out.println(obj.getClass().getName());
			System.out.println(obj);
		}
		HibernateSessionFactory.closeSession();
	}
	//@Test
	//�������Ĳ�ѯ���
	public void test5(){
		//SQL select * from d_user where nickname like 'gook%' 
		//String hql = "from User where nickname like ?";
		String hql = "from User where nickname like :name";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		//���ò�������������0��ʼ
		//query.setString(0,"%s%");
		query.setString("name", "%o%");
		List<User> list = query.list();
		for(User obj:list){
			System.out.println(obj.getId()+" "+obj.getNickname()+" "+obj.getEmail());
		}
		HibernateSessionFactory.closeSession();
	}
	//@Test
	//��HQLд�뵽hbm.xml��
	public void test6(){
		Session session = HibernateSessionFactory.getSession();
		//��ȡhbm.xml�е�HQL
		Query query = session.getNamedQuery("findById");
		//��hql�еģ�id���ò���ֵ
		query.setInteger("id", 1);
		List<User> list = query.list();
		for(User obj:list){
			System.out.println(obj.getId()+" "+obj.getNickname()+" "+obj.getEmail());
		}
		HibernateSessionFactory.closeSession();
	}
	//��ҳ��ѯ
	@Test
	public void test7(){
		Session session = HibernateSessionFactory.getSession();
		//��ȡhbm.xml�е�HQL
		Query query = session.getNamedQuery("findAll");
		//���÷ֲ���ѯ����
		//����ץȡ��¼����ʼλ�ã���0��ʼ
		query.setFirstResult(0);
		//�������ץȡ5��
		query.setMaxResults(5);
		List<User> list = query.list();
		for(User obj:list){
			System.out.println(obj.getId()+" "+obj.getNickname()+" "+obj.getEmail());
		}
		HibernateSessionFactory.closeSession();
	}
}
