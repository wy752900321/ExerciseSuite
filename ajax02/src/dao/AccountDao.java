package dao;

import entity.Account;

public interface AccountDao {
	public Account findByAccountNo(String accountNo) throws Exception;
}
