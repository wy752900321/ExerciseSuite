package com.tarena.aop;

import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("exceptionloggerbean")
@Scope("singleton")
@Aspect
public class ExceptionLogger {
	private Logger log = Logger.getLogger(this.getClass());

	@Pointcut("within(com.tarena.dao.impl.*)")
	public void daocut() {

	}

	// @AfterReturning
	// @After("")
	// @Before("")
	@AfterThrowing(pointcut = "daocut()", throwing = "ex")
	public void exceptionLogger(Exception ex) {

		// 将ex对象写入文件日志

		log.error("异常类型：" + ex + "发生时间：" + new Date());

		// 放了堆栈信息,
		StackTraceElement[] elements = ex.getStackTrace();
		System.out.println(elements[0]);
	}
}
