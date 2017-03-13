package basic.day19.reflection;

import java.lang.reflect.Method;

/**反射高级
 * 演示一个向方法中传递参数的实例。以调用Person3类的sayHello(String naem,int age)方法为例，此方法需要两个参数
 */
public class InvokeSayHelloDemo {
	public static void main(String[] args) {
		Class<?> c1 = null;
		try{
			c1 = Class.forName("basic.day19.reflection.Person3");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			Method met = c1.getMethod("sayHello", String.class,int.class);//此方法需要两个参数
			String rv =null;//接收方法的返回值
			//调用方法，必须传递对象实例，同时传递两个参数值
			rv = (String) met.invoke(c1.newInstance(), "贾东坡",21);
			System.out.println(rv);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
