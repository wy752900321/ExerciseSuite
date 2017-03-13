package basic.day18.mldn.generics;
/**泛型 的 安全警告
 *在泛型应用中最好在声明类对象时指定其内部的数据类型，如：Info<String>,
 *如果不指定类型，这样用户在使用这样的类时，就会出现不安全的警告信息
 */
/*
 * 编译时出现警告，但是并不影响程序的运行。没有指定时，所有的类型统一使用Object进行接收。
 * 下边的var属性实际上是Object类型的
 * Info<Object> i = new Info<Object>();//警告，没有指定泛型类型
		i.setVar("贾东坡");
		System.out.println("内容："+i.getVar());
 */
class Info<T>{//此处可以是任意的标识符号，T是type的简称
	private T var ;

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
	@Override
	public String toString() {
		return this.var.toString();
	}
}
public class GenericsDemo07 {
	public static void main(String[] args) {
		Info i = new Info();//警告，没有指定泛型类型
		i.setVar("贾东坡");
		System.out.println("内容："+i.getVar());
	}
}
