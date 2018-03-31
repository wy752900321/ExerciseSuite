package org.tarena.dang.interceptor;

import org.apache.log4j.Logger;
import org.tarena.dang.util.DBUtil;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TransactionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -6273522664384938108L;
	private Logger log = Logger.getLogger(this.getClass());
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//执行事务管理
		try {
			//开始事务
			DBUtil.openConnection().setAutoCommit(false);
			log.warn(".............Transaction Begin......................");
			String result = invocation.invoke();//调用Action->result
			//提交事务
			DBUtil.openConnection().commit();
			log.warn(".............Transaction commit()......................");
			return result;//返回Action业务方法的String值
		} catch (Exception e) {
			//如果Action的execute抛出异常执行
			e.printStackTrace();
			
			DBUtil.openConnection().rollback();//回滚事务
			log.warn(".............Transaction End......................");
			return "error";
		}finally{
			DBUtil.closeConnection();
		}
	}

}
