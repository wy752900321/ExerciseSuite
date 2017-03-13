package com.wangxin.interceptor;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wangxin.util.DBPoolUtil;

public class TransInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			DBPoolUtil.getConnection().setAutoCommit(false);
			invocation.invoke();
			DBPoolUtil.getConnection().commit();
		} catch (Exception e) {
			e.printStackTrace();
			DBPoolUtil.getConnection().rollback();
		}finally{
			DBPoolUtil.close();
		}
		
		return null;
	}
		
}
