package com.tarena.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.tarena.entity.Category;
import com.tarena.util.HibernateUtil;

public class TestCategory {
//	@Test
	public void testLoad(){
		Session session = HibernateUtil.getSession();
		Category cat = 
			(Category)session.load(Category.class, 2);
		System.out.println(cat.getId()+" "+cat.getName());
		System.out.println("------包含以下子类别------");
		for(Category c:cat.getSubCats()){
			System.out.println(c.getId()+" "+c.getName());
		}
		HibernateUtil.closeSession();
	}
	
//	@Test
	public void testLoad1(){
		Session session = HibernateUtil.getSession();
		String hql = 
			    "select distinct c " +
			    "from Category c join fetch c.subCats " +
				"where c.parentId=1";
		Query query = session.createQuery(hql);
		List<Category> cats = query.list();
		for(Category cat : cats){
			System.out.println(cat.getId()+" "+cat.getName());
			System.out.println("------包含以下子类别------");
			for(Category c:cat.getSubCats()){
				System.out.println(c.getId()+" "+c.getName());
			}
		}
		HibernateUtil.closeSession();
	}
	
	@Test
	public void testLoad2(){
		Session session = HibernateUtil.getSession();
		String hql = 
			    "select distinct c " +
			    "from Category c join fetch c.listCats " +
				"where c.parentId=1";
		Query query = session.createQuery(hql);
		List<Category> cats = query.list();
		for(Category cat : cats){
			System.out.println(cat.getId()+" "+cat.getName());
			System.out.println("------包含以下子类别------");
			for(Category c:cat.getListCats()){
				System.out.println(c.getId()+" "+c.getName());
			}
		}
		HibernateUtil.closeSession();
	}
}
