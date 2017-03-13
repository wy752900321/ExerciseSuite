package org.colin.dang.dao.impl;


import java.util.List;

import org.colin.dang.dao.RecommendDAO;
import org.colin.dang.pojo.Book;
import org.colin.dang.pojo.Product;
import org.hibernate.SQLQuery;

public class RecommendDAOImpl extends BaseDAO implements RecommendDAO{

	public List<Book> findRecommend(int size) {
		String hql="select * " +
		"from d_product dp join d_book db on(dp.id=db.id) where has_deleted=0 " +
		"order by rand() " +
		"limit ?";
	SQLQuery query=this.getSession().createSQLQuery(hql);
	query.setInteger(0,size);
	query.addEntity(Book.class);
		List<Book> list=query.list();
		this.closeSession();
		return list;
	}
/*public static void main(String[] args) {
	RecommendDAO reDao=new RecommendDAOImpl();
	List<Book> list=reDao.findRecommend(2);
	for(Book pro:list){
		System.out.println(pro.getId());
	}
}*/
}
