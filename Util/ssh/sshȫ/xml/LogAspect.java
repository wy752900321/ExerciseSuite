package com.wangxin.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import com.wangxin.util.PropertiesUtil;

//切面组建用于封装操作日志组建
public class LogAspect {
	Logger logger = Logger.getLogger(LogAspect.class);
	//采用环绕通知切入
	public Object logger(ProceedingJoinPoint pjp)throws Throwable{
		System.out.println("开始执行");
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().getSimpleName();
		String key = className+"."+methodName;
		String message = PropertiesUtil.getValue(key);
		Object obj = pjp.proceed();//调用目标对象的方法
		System.out.println(message+"－－完成");
		logger.info(message);
		return obj;
	}
}
