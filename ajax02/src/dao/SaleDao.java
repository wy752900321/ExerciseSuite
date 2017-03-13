package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Sale;

public class SaleDao {

	public List<Sale> find() throws Exception {
			Connection conn = DBUtil.getConnection();
			PreparedStatement prep = conn.prepareStatement("select * from t_sale order by qty desc limit 3");
			ResultSet rs = prep.executeQuery();
			List<Sale> sales = new ArrayList<Sale>();
			while(rs.next()){
				Sale sa = new Sale(
					rs.getString("name"),
					rs.getInt("qty")
					);
			sales.add(sa);
			}
			DBUtil.close(conn);
			return sales;
	}
}