package com.tarena.test;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.tarena.entity.Category;
import com.tarena.entity.Product;
import com.tarena.util.HibernateSessionFactory;

public class TestCategory {
	@Test
	public void testLoad(){
		Session session = 
			HibernateSessionFactory.getSession();
		Category cat = 
			(Category)session.load(Category.class, 9);
		System.out.println(cat.getId()+" "+cat.getName());
		System.out.println("-----包含以下商品-----");
		Set<Product> pros = cat.getPros();
		for(Product pro:pros){
			System.out.println("商品ID:"+pro.getId()+" "
					+"商品名:"+pro.getProductName()+" "
					+"商品图片:"+pro.getProductPic());
		}
		HibernateSessionFactory.closeSession();
	}
}
