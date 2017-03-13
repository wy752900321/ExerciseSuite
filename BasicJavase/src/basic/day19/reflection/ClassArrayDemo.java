package basic.day19.reflection;

import java.lang.reflect.Array;

/**反射高级
 *取得数组信息并修改数组内容
 *并通过Array类中的set()方法修改了数组中的元素内容
 */
public class ClassArrayDemo {
	public static void main(String[] args) {
		int temp[] ={1,2,3};//声明一个整形数组
		Class<?> c = temp.getClass().getComponentType();//取得数组的Class对象
		System.out.println("类型："+c.getName());//得到数组类型名称
		System.out.println("长度："+Array.getLength(temp));//得到数组长度
		System.out.println("第一个内容："+Array.get(temp, 0));//得到第一个内容
		
		Array.set(temp, 0, 6);//修改第一个内容
		System.out.println("第一个内容："+Array.get(temp,0));//得到第一个内容
	}
}
