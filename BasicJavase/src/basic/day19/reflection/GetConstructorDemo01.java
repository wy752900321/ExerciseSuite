package basic.day19.reflection;

import java.lang.reflect.Constructor;
/**取得全部构造方法1
 *Class类的getConstructors()
 */
public class GetConstructorDemo01 {
	public static void main(String[] args) {
		Class<?> c1 = null;//声明Class对象
		try{
			c1 = Class.forName("basic.day19.reflection.Person3");//实例化Class对象
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Constructor<?> con[] = c1.getConstructors();//得到全部构造方法
		for(int i=0;i<con.length;i++){//循环输出
			System.out.println("构造方法："+con[i]);//直接打印输出
		}
	}
}
