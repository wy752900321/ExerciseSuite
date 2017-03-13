package test;

import dao.AccountDao;
import dao.impl.AccountDaoImpl;
import entity.Account;

public class TestDao {
	public static void main(String[] args) {
		AccountDao dao = new AccountDaoImpl();
		try{
			Account account = dao.findByAccountNo("666666");
			System.out.println(account.getBalance());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
