package basic.day18.mldn.generics;
/**泛型的下限
	当使用的泛型只能在本类及其父类类型上应用时，就必须使用泛型 的范围下限进行配置
	[格式10-5 设置下限]
	声明对象：类名称<? super 类> 对象名称
	定义类：[访问权限] 类名称<泛型标识 extends 类>{}
 */
class Info3<T>{
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
public class GenericsDemo12 {
	public static void main(String[] args) {
		Info<Object> i1 = new Info<Object>();//满足下限范围
		Info<String> i2 = new Info<String>();
		i1.setVar(new Object());//设置Object对象
		i2.setVar("李兴华");//设置字符串
		fun(i1);
		fun(i2);
	}
	public static void fun(Info<? super String> temp){//只能接收String或Object类型的泛型
		System.out.println("内容："+temp);
	}
}
