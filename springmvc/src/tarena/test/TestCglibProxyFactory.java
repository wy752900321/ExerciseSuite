package tarena.test;

import tarena.proxy.CglibProxyFactory;
import tarena.service.EmpService;

public class TestCglibProxyFactory {
	public static void main(String[] args){
		EmpService service = new EmpService();
		CglibProxyFactory proxyFactory = new CglibProxyFactory();
		EmpService service1 = (EmpService)
			proxyFactory.getProxy(service);
		service1.add();
	}
}
