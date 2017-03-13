package basic.day19.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * 如果要完成动态代理，首先定义一个InvocationHandler接口的子类，以完成代理的具体操作
 * 在MyInvocationHandler类的bind()方法中接受被代理对象的真实主题实现，之后覆写InvocationHandler接口中的
 * invoke()方法，完成具体的方法调用 
 */
public class MyInvocationHandler implements InvocationHandler {
	private Object obj;//真实主题
	public Object bind(Object obj){//绑定真实操作主题
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().
				getClassLoader(),obj.getClass().getInterfaces(),this);//取得代理对象
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {//动态调用方法
		Object temp = method.invoke(this.obj, args);//调用方法，传入真实主题和参数
		return temp;//返回方法的返回信息
	}
	
}
