package com.tarena.dao.impl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.tarena.dao.MoreOtherBooksDAO;
import com.tarena.dao.ProductDAO;
import com.tarena.entity.Product;

public class MoreOtherBooksDAOImpl extends GetConnection implements MoreOtherBooksDAO{
	private static final String FindHotProductNumber = 
		 "select dp.id,dp.product_name,dp.description, "+
         " dp.add_time,dp.fixed_price,dp.dang_price , "+
         " dp.keywords,dp.product_pic,sum(di.product_num) sum from d_product dp "+
         " join d_item di on ( di.product_id = dp.id) "+
         " join d_book db on (dp.id = db.id) "+
         " where dp.has_deleted=0 "+
         " group by dp.id order by sum desc ";
	
	public List<Product> findHotProduct(int page, int hotNum) throws Exception {
		ProductDAO proDao = new ProductDAOImpl();
		List<Product> list = proDao.findHotProduct(page, hotNum);
		return list;
	}

	public int findHotProductNumber() throws Exception {
		int i = 0;
		Statement stmt =  getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(FindHotProductNumber);
		while(rs.next()){
			++i;
		}
		return i;
	}
	
}
