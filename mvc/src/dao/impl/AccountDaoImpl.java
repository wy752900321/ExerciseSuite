package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBUtil;
import dao.AccountDao;
import entity.Account;

public class AccountDaoImpl implements AccountDao{

	@Override
	public Account findByAccountNo(String accountNo) throws Exception {
		Account a = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement prep = conn.prepareStatement("select * from t_account where accountNo=?");
		prep.setString(1, accountNo);
		ResultSet rst = prep.executeQuery();
		if(rst.next()){
			a = new Account();
			a.setAccountNo(accountNo);
			a.setBalance(rst.getDouble("balance"));
			a.setId(rst.getLong("id"));
		}
		DBUtil.close(conn);
		return a;
	}

}
