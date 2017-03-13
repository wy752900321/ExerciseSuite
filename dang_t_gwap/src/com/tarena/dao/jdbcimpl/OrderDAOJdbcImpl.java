package com.tarena.dao.jdbcimpl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tarena.dao.OrderDAO;
import com.tarena.entity.Order;
import com.tarena.util.DbPoolUtil;

/**
 * 创建定单
 * 
 * @author soft01
 * 
 */
public class OrderDAOJdbcImpl implements OrderDAO, Serializable {
	private static final long serialVersionUID = 1092700196229528739L;
	private static final String createOrder = "insert into d_order(user_id,"
			+ "status,order_time,order_desc,total_price,receive_name,"
			+ "full_address,postal_code,mobile,phone) values(?,?,?,?,?,"
			+ "?,?,?,?,?)";

	/**
	 * 创建定单
	 * 
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public int createOrder(Order order) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句，并返回主键值
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				createOrder, PreparedStatement.RETURN_GENERATED_KEYS);
		// 4.设置参数
		stat.setInt(1, order.getUserId());
		stat.setInt(2, 1);
		stat.setLong(3, System.currentTimeMillis());
		stat.setString(4, order.toString());
		stat.setDouble(5, order.getTotalPrice());
		stat.setString(6, order.getReceiveName());
		stat.setString(7, order.getFullAddress());
		stat.setString(8, order.getPostalCode());
		stat.setString(9, order.getMobile());
		stat.setString(10, order.getPhone());
		// 5.执行语句对象
		stat.executeUpdate();
		// 6.返回结果集
		ResultSet set = stat.getGeneratedKeys();
		set.next();
		int i = set.getInt(1);
		return i;
	}

	// public static void main(String[] args) throws Exception {
	// Order order = new Order(1, 1, System.currentTimeMillis(), null, 1800,
	// "张三", "dsflakdjsfoewij", "110000", "01012345678", "12345678901");
	// OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance("OrderDAO");
	// orderDAO.createOrder(order);
	// }

}
