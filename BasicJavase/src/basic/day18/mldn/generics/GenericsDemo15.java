package basic.day18.mldn.generics;
/**
 *[访问权限] <泛型标识> 泛型标识 方法名称(泛型标识 参数名称)
 */
class Demo{
	public <T> T fun(T t){//可以接收任意类型的数据
		return t;
	}
}
public class GenericsDemo15 {
	public static void main(String[] args) {
		Demo d = new Demo();
		String str = d.fun("贾东坡");//传递字符串
		int i=d.fun(30);//传递数字，自动装箱
		System.out.println(str);//输出内容
		System.out.println(i);//输出内容
	}
}
