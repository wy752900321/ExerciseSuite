package tarena.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory 
	implements InvocationHandler{
	private Object target;
	/**
	 * 根据目标对象生成一个代理对象
	 * @param target 目标对象
	 * @return 代理对象
	 */
	public Object getProxy(Object target){
		this.target = target;
		//newProxyInstance参数：目标对象的类加载路径，当前接口，InvocationHandler的实现
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				this);//this就是InvocationHandler的实现invode方法
	}
	//定义回调函数
	//当通过代理对象执行业务方法时,会自动调用该方法
	public Object invoke(Object proxy, 
			Method method, Object[] args) throws Throwable {
		try{
			System.out.println("前置通知处理");
			//调用目标对象方法
			Object retVal = method.invoke(target, args);
			System.out.println("后置通知处理");
			return retVal;
		}catch(Exception ex){
			System.out.println("异常通知处理");
			return null;
		}finally{
			System.out.println("最终通知处理");
		}
	}
}

//public class $prxoy1 implements 目标对象接口{}


