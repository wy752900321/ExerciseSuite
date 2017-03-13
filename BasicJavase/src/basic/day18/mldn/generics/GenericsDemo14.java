package basic.day18.mldn.generics;
/**
 * 使用泛型接口的子类
 *与Info5.java相关联
 */
public class GenericsDemo14 {
	public static void main(String[] args) {
		Info5<String> i = null;//定义接口对象，指定泛型
		i=new InfoImpl2("李兴华");//通过子类实例化此对象，不用指定泛型
		System.out.println("内容"+i.getVar());
	}
}
