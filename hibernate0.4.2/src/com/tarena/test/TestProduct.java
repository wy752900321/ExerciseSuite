package com.tarena.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.tarena.entity.Category;
import com.tarena.entity.Product;
import com.tarena.util.HibernateSessionFactory;

public class TestProduct {
//	@Test
	public void testLoad(){
		Session session =
			HibernateSessionFactory.getSession();
		Product pro = 
			(Product)session.load(Product.class, 1);
		System.out.println(pro.getId()+" "
				+pro.getProductName());
		System.out.println("----该产品属于以下类别----");
		Set<Category> cats =  pro.getCats();
		for(Category c : cats){
			System.out.println(c.getId()+" "+c.getName());
		}
		HibernateSessionFactory.closeSession();
	}
	
//	@Test
	public void testDelete(){
		Session session =
			HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Product pro = 
			(Product)session.load(Product.class, 23);
		session.delete(pro);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
	
	@Test
	//给一个类别指定包含多个商品
	public void test1(){
		Session session =
			HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Category cat = 
			(Category)session.load(Category.class, 8);
		Product pro1 = 
			(Product)session.load(Product.class, 1);
		Product pro2 = 
			(Product)session.load(Product.class, 2);
		//将pro指定给cat
		cat.getPros().add(pro1);
		cat.getPros().add(pro2);
		//将关系数据更新到d_category_product表
		session.update(cat);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
	
	
}
