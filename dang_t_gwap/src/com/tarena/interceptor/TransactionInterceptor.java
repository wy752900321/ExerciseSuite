package com.tarena.interceptor;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tarena.util.DbPoolUtil;

/**
 * 事务拦截器
 * 
 * @author soft01
 * 
 */
public class TransactionInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -2996969084618907383L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			// 把自动提交设成false
			DbPoolUtil.getConnection().setAutoCommit(false);
			// 调用拦截器
			invocation.invoke();
			// 提交
			DbPoolUtil.getConnection().commit();
		} catch (Exception e) {
			Logger logger = Logger.getLogger(TransactionInterceptor.class);
			logger.error("事务出错，回滚之前的异常信息", e);
			DbPoolUtil.getConnection().rollback();
		} finally {
			// 关闭数据库连接
			DbPoolUtil.close();
		}
		return null;
	}

}
