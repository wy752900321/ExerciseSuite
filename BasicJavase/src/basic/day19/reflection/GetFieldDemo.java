package basic.day19.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

//取得类中属性
public class GetFieldDemo {
	public static void main(String[] args) {
		Class<?> c1 = null;
		try {
			c1 = Class.forName("basic.day19.reflection.Person3");// 实例化Class对象
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		{
			Field f[] = c1.getDeclaredFields();// 得到本类属性
			for (int i = 0; i < f.length; i++) {
				Class<?> r = f[i].getType();// 得到属性的类型
				int mod = f[i].getModifiers();// 得到修饰符数字
				String priv = Modifier.toString(mod);// 取得属性的修饰符
				System.out.print("本类属性");
				System.out.print(priv + " ");// 输出修饰符
				System.out.print(r.getName() + " ");// 输出属性类型
				System.out.print(f[i].getName());// 输出属性名称
				System.out.println(";");// 换行
			}
		}
		System.out.println("------------------------------------------------");
		{
			Field f[] = c1.getFields();// 得到父类公共属性
			for (int i = 0; i < f.length; i++) {
				Class<?> r = f[i].getType();// 得到属性类型
				int mod = f[i].getModifiers();// 取得修饰符数字
				String priv = Modifier.toString(mod);// 取得属性修饰符
				System.out.print("公共属性：");
				System.out.print(priv + " ");// 输出修饰符
				System.out.print(r.getName() + " ");// 输出属性类型
				System.out.print(f[i].getName());// 输出属性名称
				System.out.println(";");// 换行
			}
		}
	}
}
