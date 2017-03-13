package basic.day18.mldn.generics;
/**也可以在类的声明处指定泛型的上限范围。
 * [格式10-4 设置上限]
	声明对象：类名称<? extends 类> 对象名称
	定义类：[访问权限] 类名称<泛型标识 extends 类>{}
 */
public class GenericsDemo11 {
	public static void main(String[] args) {
		Info2<Integer> i1 = new Info2<Integer>();//
		System.out.println("内容："+i1);
		
		//错误声明
		//Info<String> i2 = new Info(String)();
		//System.out.println("内容："+i2);
	}
}
class Info2<T extends Number>{
	private T var;

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