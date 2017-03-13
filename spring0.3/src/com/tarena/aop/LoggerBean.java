package com.tarena.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tarena.util.PropertiesUtil;

/**
 * 记录操作日志
 */
@Component("loggerbean")
@Scope("singleton")
@Aspect//将当前组件指定为切面 
public class LoggerBean {
	
	@Pointcut("within(com.tarena.dao.impl.*)")
	public void daocut(){
		
	}
	
	// ProceedingJoinPoint连接点对象
	@Around("daocut()")//采用环绕通知，使用daocut()切入点
	public Object optLogger(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("前期处理逻辑");// 前置通知
		
		Object obj = pjp.proceed();// 执行目标对象方法,得到返回值obj
		
		System.out.println("后期处理逻辑");
		
		// 获取目标对象类型pjp.getTarget()
		String clazzName = pjp.getTarget().getClass().getName();
		
		// 获取目标对象方法名pjp.getSignature()
		String methodName = pjp.getSignature().getName();

		// 拼成一个“类名.方法名”的key
		String key = clazzName + "." + methodName;
		
		// 去opt.properties文件中获取操作名
		String msg = PropertiesUtil.getProperty(key);
		
		//将操作名,用户名,时间拼成信息,
		//从控制台输出,也可以利用文件或db输出
		String user = "张三";// TODO 从sesison获取
		System.out.println(user + "执行" + msg + " " + new Date());
		System.out.println(msg);

		return obj;
	}
	// 后置通知
	/*
	 * public void optLogger2(String n){
	 * 
	 * }
	 */
}
