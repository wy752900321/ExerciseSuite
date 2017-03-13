package com.tarena.dao.jdbcimpl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.ItemDAO;
import com.tarena.entity.Item;
import com.tarena.util.DbPoolUtil;

/**
 * d_item的信息处理逻辑
 * 
 * @author soft01
 * 
 */
public class ItemDAOJdbcImpl implements ItemDAO,Serializable {
	private static final long serialVersionUID = -1377362894248712858L;
	// 插入数据
	private static final String insert = "insert into d_item(order_id,"
			+ "product_id,product_name,dang_price,product_num,amount) "
			+ "values(?,?,?,?,?,?)";
	// 通过id找商品
	private static final String findByProductId = "select * from "
			+ "d_item di join d_product dp on (dp.id=di.product_id) "
			+ "where di.product_id=?";

	/**
	 * 插入数据
	 * 
	 * @param item
	 * @throws Exception
	 */
	public void insert(Item item) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				insert);
		// 4.设置参数
		stat.setInt(1, item.getOrderId());
		stat.setInt(2, item.getProductId());
		stat.setString(3, item.getProductName());
		stat.setDouble(4, item.getDangPrice());
		stat.setInt(5, item.getProductNum());
		stat.setDouble(6, item.getAmount());
		// 5.执行语句对象
		stat.executeUpdate();
	}

	/**
	 * 通过product_id找出商品明细
	 * 
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public List<Item> findByProductId(int productId) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findByProductId);
		// 4.设置参数
		stat.setInt(1, productId);
		// 5.执行语句对象
		// 6.返回结果集
		ResultSet set = stat.executeQuery();
		List<Item> list = new ArrayList<Item>();
		// 7.赋值
		while (set.next()) {
			Item item = new Item(set.getInt("order_id"), productId, set
					.getString("product_name"), set.getDouble("dang_price"),
					set.getInt("product_num"), set.getDouble("amount"));
			list.add(item);
		}
		return list;
	}

}
