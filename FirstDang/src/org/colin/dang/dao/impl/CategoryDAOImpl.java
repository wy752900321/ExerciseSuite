package org.colin.dang.dao.impl;

import java.util.List;

import org.colin.dang.dao.CategoryDAO;
import org.colin.dang.pojo.Book;
import org.colin.dang.pojo.Category;
import org.colin.dang.pojo.Product;
import org.hibernate.Query;

public class CategoryDAOImpl extends BaseDAO implements CategoryDAO{

	public List<Category> findByParentId(int parentId) {
		String hql = "select distinct c " +
		"from Category c left outer " +
		"join fetch c.subCats " +
		"where c.parentId=? " +
		"order by c.turn";
		Query query=this.getSession().createQuery(hql);
		query.setInteger(0,parentId);
		List list=query.list();
		return list;
	}

	public List<Book> findByCatId(int catId, int page, int pageSize) {
		String hql="select dp from Category dc join dc.pros dp where dc.id=?";
		List<Book> list=this.getSession().createQuery(hql).setInteger(0,catId)
		    .setFirstResult((page-1)*pageSize)
		    .setMaxResults(pageSize).list();
		return list;
	}

	public List<Product> findProductByCatId(int catId) {
		String hql="select dp from Category dc join dc.pros dp where dc.id=?";
		List<Product> list=this.getSession().createQuery(hql).setInteger(0,catId).list();
		
		return list;
	}
public static void main(String[] args) {
	CategoryDAO ca=new CategoryDAOImpl();
	List<Category> list=ca.findByParentId(2);
	//System.out.println(list.size());
	//List<Category> list=ca.findProductByCatId(9);
	for(Category co:list){
		System.out.println(co.getId());
	}
	
}
}
