package com.tarena.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tarena.util.DbPoolUtil;

public class TransactionInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -2996969084618907383L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			DbPoolUtil.getConnection().setAutoCommit(false);
			System.out.println("事务开始");
			invocation.invoke();
			DbPoolUtil.getConnection().commit();
			System.out.println("事务结束");
		} catch (Exception ex) {
			ex.printStackTrace();
			DbPoolUtil.getConnection().rollback();
			System.out.println("事务回滚");
		}finally{
			DbPoolUtil.closeConnection();
		}
		return null;
	}

}
