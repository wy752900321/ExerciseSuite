package tarena.test;

import tarena.proxy.JdkProxyFactory;
import tarena.service.UserService;
import tarena.service.UserServiceImpl;

public class TestJdkProxyFactory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserService service = new UserServiceImpl();
		JdkProxyFactory proxyFactory = 
				new JdkProxyFactory();
		UserService serviceProxy = (UserService)
			proxyFactory.getProxy(service);
		System.out.println(serviceProxy.getClass().getName());
		serviceProxy.register();//触发invoke方法
		System.out.println("---------------");
		serviceProxy.delete();//触发invoke方法
	}

}
