package service;

import java.util.Random;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import entity.Account;
import exception.AccountLimitException;
import exception.AccountNotExistException;

public class AccountService {
		public String apply(String accountNo,double amount) throws Exception{
			//先依据账号查询数据库
			AccountDao dao = new AccountDaoImpl();
			Account a = dao.findByAccountNo(accountNo);
			if(a == null){
				//账号不存在
				throw new AccountNotExistException();
			}
			if(amount > a.getBalance()*10){
				//余额不足
				throw new AccountLimitException();
			}
			//生成一个序号，用户可以通过这个序号去柜号押理剩余的手续
			Random r = new Random();
			return r.nextInt(99999)+"";
		}
}
