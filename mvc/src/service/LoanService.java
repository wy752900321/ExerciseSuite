package service;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import entity.Account;
import exception.AccountLimitException;
import exception.AccountNotExistException;

/**
 * 处理业务类
 * @author soft01
 *
 */
public class LoanService {
	public double apply(String accountNO,double amount) throws Exception{
		AccountDao dao = new AccountDaoImpl();
		Account a = dao.findByAccountNo(accountNO);
		if(a == null){
			/*
			 		账号不存在  可以抛出一个应用异常给调用 者。
			 		应用异常：一般是由于用户的误操作引起的异常，比如输入了一个不存在的账号。
			 		这样的异常一般都是可以恢复的。比如让用户重新输入一遍账号。
			 */
			throw new AccountNotExistException();
		}
		if(a.getBalance()*2<amount){
			throw new AccountLimitException();
		}
		return amount;
	}
}
