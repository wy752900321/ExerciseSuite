package basic.day18.mldn.generics;

/**
 * 通配符 在泛型 类的操作中，在进行引用传递时泛型类型必须匹配才可以传递，否则是无法传递的。
 * 虽然没有语法错误，但是fun()方法中Info中并没有指定任何的泛型类型，这样做不妥当，所以为了解决这个问题，
 * java中引入通配符“？”，表示可以接收此类型的任意泛型对象。
 * 虽然合理了，但是在使用上语法时也有一个注意点，即如果使用了“?”接收泛型对象，则不能设置被泛型指定的内容，如下：
 */
public class GenericsDemo08 {
	public static void main(String[] args) {
		Info<String> i = new Info<String>();// 指定String为泛型泛型类型
		i.setVar("贾东坡");

		// 如果想正确执行，可以将fun()方法中定义的Info<Object>修改为Info，即不指定泛型
		fun(i);// 1.Info<Object>时，编译错误
	}

	// 1.Info<Object>时，编译错误
	// 尽管String是Object类的子类，但是在进行引用传递时也同样无法进行操作，
	// public static void fun(Info<Object> temp){//此处可以接收Object类型
	// System.out.println("内容："+temp);
	// }
	// 2.Info时，正常运行
	// public static void fun(Info temp) {// 此处可以接收Object类型
	// System.out.println("内容：" + temp);
	// }
	// 3.Info<?>，正常运行
	public static void fun(Info<?> temp) {// 此处可以接收Object类型
		System.out.println("内容：" + temp);
	}
}
