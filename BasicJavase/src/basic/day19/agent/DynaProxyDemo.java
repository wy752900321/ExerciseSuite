package basic.day19.agent;
/**
 *测试动态代理
 *从程序运行结果可以发现，完成的功能与静态代理操作没什么不同，所以在一般的开发中很少使用到这种动态代理机制，但是在编写
 *一些底层代码或使用一些框架(如Spring Framework)时，这种动态代理模式就比较常用了。
 */
public class DynaProxyDemo {
	public static void main(String[] args) {
		MyInvocationHandler handler = new MyInvocationHandler();//实例化代理操作类
		Subject sub = (Subject)handler.bind(new RealSubject());//绑定对象
		String info = sub.say("贾东坡", 21);//通过动态代理调用方法
		System.out.println(info);//信息输出
	}
}
