package tarena.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyFactory implements MethodInterceptor{
	private Object target;
	/**
	 * 根据目标对象生成代理对象
	 * @param target
	 * @return
	 */
	public Object getProxy(Object target){
		this.target = target;
		Enhancer hancer = new Enhancer();
		hancer.setSuperclass(target.getClass());
		hancer.setCallback(this);
		return hancer.create();//创建代理对象
	}
	//当通过代理对象调用业务方法时,自动执行该方法
	public Object intercept(
			Object proxy, 
			Method method, Object[] params, 
			MethodProxy arg3) throws Throwable {
		System.out.println("前置通知处理");
		//调用目标对象方法
		Object retVal = method.invoke(target, params);
		System.out.println("后置通知处理");
		return retVal;
	}
}
