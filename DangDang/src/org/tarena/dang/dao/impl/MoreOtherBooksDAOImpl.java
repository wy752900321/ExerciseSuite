package org.tarena.dang.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.tarena.dang.dao.MoreOtherBookDAO;
import org.tarena.dang.dao.ProductDAO;
import org.tarena.dang.entity.Product;
import org.tarena.dang.util.DBUtil;

public class MoreOtherBooksDAOImpl implements MoreOtherBookDAO {
	private static final String FindHotProductNumber = 
		"select dp.id,dp.product_name,dp.description, "+
        " dp.add_time,dp.fixed_price,dp.dang_price , "+
        " dp.keywords,dp.product_pic,sum(di.product_num) sum from d_product dp "+
        " join d_item di on ( di.product_id = dp.id) "+
        " join d_book db on (dp.id = db.id) "+
        " where dp.has_deleted=0 "+
        " group by dp.id order by sum desc ";
	@Override
	public List<Product> findHotProduct(int page, int hotNum) throws Exception {
		ProductDAO proDao = new ProductDAOImpl();
		List<Product> list = proDao.findHotProduct(page, hotNum);
		return list;
	}

	@Override
	public int findHotProductNumber() throws Exception {
		int i = 0 ;
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FindHotProductNumber);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			++i;
		}
		return i;
	}

}
