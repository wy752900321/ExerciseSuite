package com.tarena.aop;

public class AopBean {
	//<aop:before method="" pointcut-ref=""/>
	public void mybefore() {
		System.out.println("前置通知处理方法");
	}

	// <aop:after-returning returnning="retVal" method="" pointcut-ref=""/>
	public void myafter(Object retVal) {
		System.out.println("后置通知处理方法");
		// reVal可接收目标对象方法的返回值
		// 如果目标方法为void,返回null
	}
	// <aop:after method="" pointcut-ref=""/>
	public void myfinal() {
		System.out.println("最终通知处理方法");
	}

	//<aop:after-throwing  pointcut-ref="" throwing="ex" method=""/>
	public void myexception() {
		System.out.println("异常通知处理方法");
	}
	
	//<aop:around pointcut-ref="" method="" />
	public Object myaround(){
		System.out.println("环绕通知处理方法");
		return null;
	}
}
