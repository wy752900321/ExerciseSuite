package basic.day19.reflection;

import java.lang.reflect.Array;

/**反射高级
 * 可以通过Array类根据已有的数组类型来开辟新的数组对象，下面就是
 * 使用Array完成一个可以修改已有数组大小的功能
 */
public class ChangeArrayDemo {
	public static void main(String[] args) {
		int temp[] = {1,2,3};
		int newTemp[] = (int[])arrayInc(temp,5);//扩大数组长度
		print(newTemp);//打印数组信息
		System.out.println("\n----------------------------");
		String t[] = {"lxh","mldn","mldnjava"};//声明一个字符串数组
		String nt[] = (String[])arrayInc(t,8);//扩大数组长度
		print(nt);//打印数组信息
	}
	/**java.lang.reflect.Array
	 	newInstance(Class<?> componentType, int length)throws NegativeArraySizeException
    		Creates a new array with the specified component type and length. 
    		Invoking this method is equivalent to creating an array as follows:
         		int[] x = {length};
         		Array.newInstance(componentType, x);
    	Parameters:
        	componentType - the Class object representing the component type of the new array
        	length - the length of the new array 
    	Returns:
        	the new array 
	 */
	public static Object arrayInc(Object obj,int len){//修改数组大小
		Class<?> c = obj.getClass();//通过数组得到Class
		Class<?> arr = c.getComponentType();//得到数组的Class对象
		Object newO = Array.newInstance(arr,len);//重新开辟新的数组大小
		int co = Array.getLength(obj);//取得数组长度
		System.arraycopy(obj,0,newO,0,co);//复制数组内容
		return newO;
	}
	public static void print(Object obj){//输出数组
		Class<?> c = obj.getClass();//通过数组得到Class对象
		if(!c.isArray()){//判断是否是数组
			return;
		}
		Class<?> arr = c.getComponentType();//取出数组的Class
		System.out.println(arr.getName()+"数组的长度是："+Array.getLength(obj));//输出数组信息
		for(int i=0;i<Array.getLength(obj);i++){//循环输出
			System.out.print(Array.get(obj, i)+",");//通过Array输出
		}
	}
}
