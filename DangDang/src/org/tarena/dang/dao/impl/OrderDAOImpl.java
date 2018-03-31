package org.tarena.dang.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.tarena.dang.dao.OrderDAO;
import org.tarena.dang.entity.Order;
import org.tarena.dang.service.CartItem;
import org.tarena.dang.util.DBUtil;

public class OrderDAOImpl implements OrderDAO{
	public static final String findOrderByUserId="select * from d_receive_address where user_id=?";
	public static final String FindOrderByOrderId="select * from d_receive_address where id=?";
	public static final String AddAddress =
		"insert into d_order(mobile,order_desc,order_time,phone," +
		"postal_code,receive_name,status,user_id,total_price,full_address) " +
			"values(?,?,?,?,?,?,?,?,?,?)";
	public static final String AddCategoryProduct=
		"insert into d_receive_address(user_id,receive_name,full_address," +
		"postal_code,mobile,phone) values(?,?,?,?,?,?)";
	public static final String AddProduct=
		"insert into d_item(order_id,product_id,product_name," +
		"dang_price,product_num,amount) values(?,?,?,?,?,?)";
	
	@Override
	public List<Order> findOrderByUserId(int user_id) throws Exception {
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(findOrderByUserId);
		List<Order> list = new ArrayList<Order>();
		pst.setInt(1, user_id);
		ResultSet rs =pst.executeQuery();
		Order order = null;
		while(rs.next()){
			order = new Order();
			order.setId(rs.getInt("id"));
			order.setMobile(rs.getString("mobile"));
			order.setPhone(rs.getString("phone"));
			order.setPostal_code(rs.getString("postal_code"));
			order.setReceive_name(rs.getString("receive_name"));
			order.setUser_id(rs.getInt("user_id"));
			order.setFull_address(rs.getString("full_address"));
			list.add(order);
		}
		return list;
	}
	
	@Override
	public String findOrderByOrderId(int address_id) throws Exception {
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(FindOrderByOrderId);
		pst.setInt(1, address_id);
		String orderStr = null;
		ResultSet rs =pst.executeQuery();
		rs.next();
		orderStr = rs.getString("receive_name")+"**"+rs.getString("full_address")+"**"+
						rs.getString("postal_code")+"**"+rs.getString("mobile")+"**"+rs.getString("phone");
		return orderStr;
	}

	@Override
	public int addAddress(int user_id, String receive_name, String full_address,
			String postal_code, String phone, String mobile, double total_price)
			throws Exception {
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(AddAddress, Statement.RETURN_GENERATED_KEYS);
		pst.setString(1, mobile);
		pst.setString(2, "订单描述");
		Date date = new Date();
		pst.setLong(3, date.getTime());
		pst.setString(4, phone);
		pst.setString(5, postal_code);
		pst.setString(6, receive_name);
		pst.setInt(7, 0);
		pst.setInt(8, user_id);
		pst.setDouble(9, total_price);
		pst.setString(10, full_address);
		return pst.executeUpdate();//获得操作数
	}

	@Override
	public void addCategoryProduct(int user_id, String receive_name,
			String full_address, String postal_code, String phone, String mobile)
			throws Exception {
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(AddCategoryProduct);
		pst.setInt(1, user_id);
		pst.setString(2, receive_name);
		pst.setString(3, full_address);
		pst.setString(4, postal_code);
		pst.setString(5, mobile);
		pst.setString(6, phone);
		pst.executeUpdate();
		
	}

	@Override
	public void addProduct(int order_id, CartItem item) throws Exception {
		PreparedStatement pst = DBUtil.openConnection().prepareStatement(AddProduct);
		pst.setInt(1, order_id);
		pst.setInt(2, item.getPro().getId());
		pst.setString(3, item.getPro().getProduct_name());
		pst.setDouble(4, item.getPro().getDang_price());
		pst.setInt(5, item.getQty());
		double amount = item.getQty()*item.getPro().getDang_price();
		pst.setDouble(6, amount);
		pst.executeUpdate();
	}

}
