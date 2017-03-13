package basic.day19.reflection;

import java.lang.reflect.Method;

/**反射高级
 *调用Person3类中的sayChina()方法
 *通过反射调用类中的方法
	操作步骤如下：
		1） 通过Class类的getMethod(String name,Class...parameterTypes)方法取得一个Method的对象，
			并设置此方法操作时所需要的参数类型
		2） 之后才可以使用invoke进行调用，并方法中传递要设置的参数
 */
public class InvokeSayChinaDemo {
	public static void main(String[] args) {
		Class<?> c1 = null;//声明Class对象
		try{
			c1 = Class.forName("basic.day19.reflection.Person3");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			Method met = c1.getMethod("sayChina");//找到方法，此方法没有参数
			met.invoke(c1.newInstance());//调用方法，必须传递对象实例
			/**
			 * 此类通过Class类的getMethod()方法取得Method对象，并通过invoke调用指定的方法。但是在使用invoke()方法时
			 * 必须传入一个类的实例化对象，因为在sayChina()方法上没有任何的参数，所以此处没有设置参数类型和参数内容
			 */
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
