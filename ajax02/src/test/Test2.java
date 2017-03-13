package test;

import exception.AccountLimitException;
import exception.AccountNotExistException;
import service.AccountService;

public class Test2 {

	public static void main(String[] args) {
		AccountService service = 
			new AccountService();
		try {
			String rs = 
				service.apply("6225881003192000", 100000);
			System.out.println("贷款申请通过，序号是:" + rs);
		} catch (Exception e) {
			e.printStackTrace();
			if(e instanceof AccountNotExistException){
				System.out.println("帐号不存在");
			}else if(e instanceof AccountLimitException){
				System.out.println("余额不足");
			}else{
				System.out.println("系统错误，销后重试");
			}
		}
	}

}
