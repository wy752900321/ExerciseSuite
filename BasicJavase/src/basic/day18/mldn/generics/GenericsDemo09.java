package basic.day18.mldn.generics;
/**
 *java中引入通配符“？”，表示可以接收此类型的任意泛型对象。
 * 虽然合理了，但是在使用上语法时也有一个注意点，
 * 即如果使用了“?”接收泛型对象，则不能设置被泛型指定的内容，如下：
 * 不过可以设置为null
 */
public class GenericsDemo09 {
	public static void main(String[] args) {
		Info<?> i = new Info<String>();//使用“？”接收泛型对象
//		i.setVar("贾东坡");//错误，无法设置
		i.setVar(null);//可以 设置
	}
}
