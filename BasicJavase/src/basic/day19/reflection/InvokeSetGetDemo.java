package basic.day19.reflection;

import java.lang.reflect.Method;

/**重点
 * 反射高级 通过setter及getter调用方法操作
 * 本程序实现思路：
 * 	1）设置方法名称，在设置方法名称时，本程序直接使用的是属性名称，例如name或age。但是实际上方法名称是setName(),
 * 			getName(),setAge(),getAge(),所有属性名称的首字母需要大写，所以为了解决这样的问题，单独设置一个方法
 * 			initStr()，通过此方法将字符串中的首字母大写。首字母大写之后再增加set及get字符串以找到对应的方法。
 *  2）调用setter()方法时，传入了实例化对象，要操作的属性名称（在方法中会将其首字母大写），要设置的参数内容以及具体的
 * 			 参数类型，这样做是为了满足getMethod()和invoke()方法的使用要求。
 * 	3） 在调用getter()方法时，也同样传入了同一个实例化对象，因为其本身不需要任何的接收参数，所以只传入了属性名称（在
 * 		方法中会将其首字母大写），并在此方法中将内容打印输出。
 * 以上程序是反射调用方法时的重要应用，必须掌握其原理。
 */
public class InvokeSetGetDemo {
	public static void main(String[] args) {
		Class<?> c1 = null;
		Object obj = null;// 声明对象
		try {
			c1 = Class.forName("basic.day19.reflection.Person3");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			obj = c1.newInstance();// 实例化操作对象
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		setter(obj, "name", "贾东坡", String.class);// 调用setter方法
		setter(obj, "age", 30, int.class);// 调用setter方法
		System.out.print("姓名：");
		getter(obj, "name");
		System.out.print("年龄：");
		getter(obj, "age");
	}

	/**
	 * @param obj操作的对象
	 * @param att操作的属性
	 * @param value设置的值
	 * @param type参数的类型
	 */
	public static void setter(Object obj, String att, Object value,
			Class<?> type) {
		try {
			Method met = obj.getClass().getMethod("set" + initStr(att), type);// 设置方法参数类型
			met.invoke(obj, value);// 调用方法
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getter(Object obj, String att) {// 调用getter方法
		try {
			Method met = obj.getClass().getMethod("get" + initStr(att));// 此方法不需要参数
			System.out.println(met.invoke(obj));// 接收方法的返回值
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String initStr(String old) {// 单词首字母大写
		String str = old.substring(0, 1).toUpperCase() + old.substring(1);
		return str;
	}
}
