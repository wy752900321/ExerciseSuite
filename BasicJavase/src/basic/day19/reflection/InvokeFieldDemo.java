package basic.day19.reflection;

import java.lang.reflect.Field;

/**
 *直接操作类中的属性
 *通过此程序可以发现，明显比之前的使用setter或getter方法操作属性代码更加简单，方便。
 *注意：这个程序是属于扩大属性的访问权限后直接操作属性，所以在Person类中并不需要编写setter和getter方法，
 *但是在开发中调用属性时都 要使用setter及getter方法，所以在开发时一定注意，不要直接操作属性，
 *而是要通过setter及getter方法调用
 */
public class InvokeFieldDemo {
	public static void main(String[] args) throws Exception {
		Class<?>  c1 = null;
		Object obj = null;
		c1 = Class.forName("basic.day19.reflection.Person3");
		obj =  c1.newInstance();//实例化对象
		Field nameField = null;//表示name属性
		Field ageField = null;//表示age属性
		nameField = c1.getDeclaredField("name");//取得name属性
		ageField = c1.getDeclaredField("age");
		nameField.setAccessible(true);//将name属性设置成可被外部访问
		
		nameField.set(obj, "贾东坡");//设置name属性内容
		ageField.setAccessible(true);//将age属性设置成可被 外部访问
		
		ageField.set(obj, 21);//设置age属性内容
		System.out.println("姓名:"+nameField.get(obj));//通过get取得属性内容
		System.out.println("年龄："+ageField.get(obj));
	}
}
