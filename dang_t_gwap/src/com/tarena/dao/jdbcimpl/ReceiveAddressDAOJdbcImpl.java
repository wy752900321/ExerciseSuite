package com.tarena.dao.jdbcimpl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.ReceiveAddressDAO;
import com.tarena.entity.ReceiveAddress;
import com.tarena.util.DbPoolUtil;

/**
 * 为d_receive_address表量身定做DAO
 * 
 * @author soft01
 * 
 */
public class ReceiveAddressDAOJdbcImpl implements ReceiveAddressDAO, Serializable {
	private static final long serialVersionUID = -588456186499953201L;
	// 往用户表插入数据
	private static final String insert = "insert into d_receive_address"
			+ "(user_id,receive_name,full_address,postal_code,mobile,phone) "
			+ "values(?,?,?,?,?,?)";
	// 列出全部数据
	private static final String findAll = "select * from "
			+ "d_receive_address";
	// 通过id找一个地址
	private static final String findById = "select * from "
			+ "d_receive_address where id=?";

	/**
	 * 插入收件人地址信息
	 * 
	 * @param receiveAddress
	 *            收件人地址对象
	 * @throws Exception
	 */
	public void insert(ReceiveAddress receiveAddress) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				insert);
		// 4.设置参数
		stat.setInt(1, receiveAddress.getUserId());
		stat.setString(2, receiveAddress.getReceiveName());
		stat.setString(3, receiveAddress.getFullAddress());
		stat.setString(4, receiveAddress.getPostalCode());
		stat.setString(5, receiveAddress.getMobile());
		stat.setString(6, receiveAddress.getPhone());
		// 5.执行语句对象
		stat.executeUpdate();
	}

	/**
	 * 列出全部收件人地址
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ReceiveAddress> findAll() throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findAll);
		// 4.执行语句对象
		// 5.返回结果集
		ResultSet set = stat.executeQuery();
		List<ReceiveAddress> list = new ArrayList<ReceiveAddress>();
		// 6.为ReceiveAddress赋值
		while (set.next()) {
			ReceiveAddress receiveAddress = new ReceiveAddress();
			int id = set.getInt("id");
			receiveAddress.setId(id);
			receiveAddress.setUserId(set.getInt("user_id"));
			receiveAddress.setReceiveName(set.getString("receive_name"));
			receiveAddress.setFullAddress(set.getString("full_address"));
			receiveAddress.setPostalCode(set.getString("postal_code"));
			receiveAddress.setMobile(set.getString("mobile"));
			receiveAddress.setPhone(set.getString("phone"));
			list.add(receiveAddress);
		}
		return list;
	}

	/**
	 * 通过id找一个收件人地址
	 * 
	 * @param id
	 *            收件人地址表id
	 * @return
	 * @throws Exception
	 */
	public ReceiveAddress findById(int id) throws Exception {
		// 1.创建连接
		// 2.创建语句对象
		// 3.接收sql语句
		PreparedStatement stat = DbPoolUtil.getConnection().prepareStatement(
				findById);
		// 4.设置参数
		stat.setInt(1, id);
		// 5.执行语句对象
		// 6.返回结果集
		ResultSet set = stat.executeQuery();
		set.next();
		// 7.为ReceiveAddress赋值
		ReceiveAddress receiveAddress = new ReceiveAddress(set
				.getInt("user_id"), set.getString("receive_name"), set
				.getString("full_address"), set.getString("postal_code"), set
				.getString("mobile"), set.getString("phone"));
		return receiveAddress;
	}

}
