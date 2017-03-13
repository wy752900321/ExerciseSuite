package basic.day18.mldn.generics;
/**
 * 定义子类方式1－－使用泛型接口的子类
 * 与Info4.java相关联
 */
public class GenericsDemo13 {
	public static void main(String[] args) {
		Info4<String> i  = null; //定义接口对象
		i  = new InfoImpl<String>("贾东坡");//通过子类实例化此对象
		System.out.println("内容："+i.getVar());
	}
}
