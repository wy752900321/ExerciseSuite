package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import dao.ComputerDAO;
import entity.Computer;

public class ComputerDAOJdbcImpl implements ComputerDAO {

	public List<Computer> findAll() throws Exception {
		Connection conn =DBUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement("select * from t_computer");
		ResultSet rst=prep.executeQuery();
		List<Computer> computers = new ArrayList<Computer>();
		/*while(rst.next()){
			Computer c = new Computer();
			c.setId(rst.getInt("id"));
			c.setModel(rst.getString("model"));
			c.setPic(rst.getString("pic"));
			c.setProdInfo(rst.getString("prodInfo"));
			c.setPrice(rst.getDouble("price"));
			computers.add(c);
		}*/
		while(rst.next()){
			Computer c = new Computer(
					rst.getString("model"),
					rst.getString("pic"),
					rst.getString("prodInfo"),
					rst.getDouble("price"));
			c.setId(rst.getLong("id"));
			computers.add(c);
		}
		DBUtil.close(conn);
		return computers;
	}

	public Computer findById(long id) throws Exception {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from t_computer where id=?");
		pst.setLong(1, id);
		ResultSet rst = pst.executeQuery();
		Computer c=null;
		/*if(rst.next()){
			c = new Computer();
			c.setId(id);
			c.setModel(rst.getString("model"));
			c.setPic(rst.getString("pic"));
			c.setProdInfo(rst.getString("propInfo"));
			c.setPrice(rst.getDouble("price"));
		}*/
		if(rst.next()){
			c = new Computer(
			rst.getString("model"),
			rst.getString("pic"),
			rst.getString("prodInfo"),
			rst.getDouble("price"));
			c.setId(id);
		}
		DBUtil.close(conn);
		return c;
	}

}
