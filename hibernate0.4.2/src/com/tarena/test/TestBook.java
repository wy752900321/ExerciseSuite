package com.tarena.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.tarena.entity.Book;
import com.tarena.entity.Product;
import com.tarena.util.HibernateSessionFactory;

public class TestBook {
//	@Test
	public void testLoadBook(){
		Session session =
			HibernateSessionFactory.getSession();
		Book book = (Book)session.load(Book.class, 1);
		System.out.println(book.getId());
		System.out.println(book.getProductName());
		System.out.println(book.getAuthor());
		System.out.println(book.getPublishing());
		HibernateSessionFactory.closeSession();
	}
	
	@Test
	public void testAddBook(){
		Session session =
			HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Book book = new Book();
		//写入d_product表的信息
		book.setProductName("hibernate");
		book.setFixedPrice(100);
		book.setDangPrice(60);
		book.setHasDeleted(0);
		//写入d_book表的信息
		book.setAuthor("ljq");
		book.setPublishing("beijing");
		book.setPublishTime(System.currentTimeMillis());
		book.setAuthorSummary("goodgood");
		book.setCatalogue("good1,good2");
		session.save(book);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
	
//	@Test
	public void testDelete(){
		Session session =
			HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Book book = (Book)session.load(Book.class, 25);
		session.delete(book);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
	
	//只取product表信息
//	@Test
	public void testLoadProduct(){
		Session session =
			HibernateSessionFactory.getSession();
		String hql = "select " +
								"pro.id," +
								"pro.productName," +
								"pro.productPic " +
							"from Product pro " +
							"where pro.id=1";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for(Object[] pro:list){
			System.out.println(pro.getClass().getName());
			System.out.println(pro[0]);
			System.out.println(pro[1]);
			System.out.println(pro[2]);
		}
		HibernateSessionFactory.closeSession();
	}
	//只取product表信息
//	@Test
	public void testLoadProduct1(){
		Session session =
			HibernateSessionFactory.getSession();
		//将返回的数据封装成一个Product对象
		String hql = "select " +
								"new Product(pro.id," +
								"pro.productName," +
								"pro.productPic) " +
							"from Product pro " +
							"where pro.id=1";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		for(Product pro:list){
			System.out.println(pro.getClass().getName());
			System.out.println(pro.getId());
			System.out.println(pro.getProductName());
			System.out.println(pro.getProductPic());
		}
		HibernateSessionFactory.closeSession();
	}
	
	
}
