package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;
import dao.AccountDao;
import entity.Account;

public class AccountDaoImpl implements AccountDao{

	
	public Account findByAccountNo(String accountNo) throws Exception {
		Account a = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement prep = conn.prepareStatement("select * from t_account where accountNo=?");
		prep.setString(1, accountNo);
		ResultSet rs = prep.executeQuery();
		if(rs.next()){
			a = new Account();
			a.setId(rs.getInt("id"));
			a.setAccountNo(accountNo);
			a.setBalance(rs.getDouble("balance"));
		}
		DBUtil.close(conn);
		return a;
	}
	
}
