package com.tarena.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.tarena.dao.IOrderDao;
import com.tarena.entity.Page;
import com.tarena.entity.exet.Book;
import com.tarena.entity.exet.Item;
import com.tarena.entity.exet.Order;
import com.tarena.util.datasource.DBConnection;

public class OrderDaoImpl implements IOrderDao {
	/**
	 * 插入订单信息并获得订单id
	 */
	@Override
	public int addOrder(Order order) {
		int orderId = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into d_order(user_id,status,order_time,order_desc,total_price,receive_name,full_address,postal_code,mobile,phone) values(?,?,?,?,?,?,?,?,?,?);";
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, order.getUserId());
			ps.setInt(2, order.getStatus());
			ps.setLong(3, order.getOrderTime());
			ps.setString(4, order.getOrderDesc());
			ps.setDouble(5, order.getTotalPrice());
			ps.setString(6, order.getReceiveName());
			ps.setString(7, order.getFullAddress());
			ps.setString(8, order.getPostalCode());
			ps.setString(9, order.getMobile());
			ps.setString(10, order.getPhone());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			while (rs.next()) {
				orderId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return orderId;
	}

	@Override
	public int addOrderItem(Item item) {
		int result = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into d_item(order_id,product_id,product_name,dang_price,product_num,amount) values(?,?,?,?,?,?);";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, item.getOrderId());
			ps.setInt(2, item.getProductId());
			ps.setString(3, item.getProductName());
			ps.setDouble(4, item.getDangPrice());
			ps.setInt(5, item.getProductNum());
			ps.setDouble(6, item.getAmount());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(ps, conn);
		}
		return result;
	}

	@Override
	public List<Book> findBookByCategoryId(Page page) {
		List<Book> books=new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from d_book,d_product,d_item where d_book.id=d_item.product_id and d_book.id=d_product.id and d_item.product_id in (select id from d_product) group by d_item.product_name order by sum(product_num) desc";
			//分页
			sql+=" limit "+page.getBegin()+","+page.getPageSize();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Book	book=new Book();
				book.setId(rs.getInt("id"));
				book.setAuthor(rs.getString("author"));
				book.setPublishing(rs.getString("publishing"));
				book.setPublishTime(rs.getLong("publish_time"));
				book.setWordNumber(rs.getString("word_number"));
				book.setWhichEdtion(rs.getString("which_edtion"));
				book.setTotalPage(rs.getString("total_page"));
				book.setPrintTime(rs.getLong("print_time"));
				book.setPrintNumber(rs.getString("print_number"));
				book.setIsbn(rs.getString("isbn"));
				book.setAuthor_summary(rs.getString("author_summary"));
				book.setCatalogue(rs.getString("catalogue"));
				book.setSavePrice(rs.getDouble("fixed_price")-rs.getDouble("dang_price"));
				book.setProductName(rs.getString("product_name"));
				book.setDescription(rs.getString("description"));
				book.setAddTime(rs.getLong("add_time"));
				book.setFixedPrice(rs.getDouble("fixed_price"));
				book.setDangPrice(rs.getDouble("dang_price"));
				book.setKeywords(rs.getString("keywords"));
				book.setHasDeleted(rs.getInt("has_deleted"));
				book.setProductPic(rs.getString("product_pic"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return books;
	}
	}
