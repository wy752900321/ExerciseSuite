package org.colin.dang.dao.impl;

import java.util.List;

import org.colin.dang.dao.ProductDAO;
import org.colin.dang.pojo.Product;
import org.colin.dang.util.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProductDAOImpl extends BaseDAO implements ProductDAO{

	public List<Product> findByAddTime(int size) {
		String hql="from Product where hasDeleted=0 order by addTime desc";
		Query query=this.getSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(size);
		List list=query.list();
		this.closeSession();
		return list;
	}

	
	public List<Product> findHot(int size) {
		String hql="select dp " +
		"from Item di join di.product dp " +
		"group by di.product.id " +
		"order by sum(di.productNum) desc";
		Query query=this.getSession().createQuery(hql).setFirstResult(0).setMaxResults(size);
		List<Product> list=query.list();
		return list;
	}


	public List<Product> findMaxCount(int size) {
		                      
		long time=168562662515l;
		long begin=System.currentTimeMillis();
		long end=begin+time;
		//System.out.println(System.currentTimeMillis());
		List<Product> list=this.getSession().createQuery(
				"select dp from Item di inner " +
				"join di.product dp group by dp.id " +
					"having dp.addTime between ? and ?" +
					" order by sum(di.productNum) desc"
		).setLong(0,begin).setLong(1,end).setFirstResult(0).setMaxResults(size).list();
		return list;
	}
/*	public static void main(String[] args) {
		ProductDAO pro=new ProductDAOImpl();
		List<Product> list=pro.findMaxCount(5);
		System.out.println(list);
		for(Product po:list){
			
			System.out.println(po.getProductName());
		}
	}*/
}
