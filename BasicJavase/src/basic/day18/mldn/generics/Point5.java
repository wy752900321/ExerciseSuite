package basic.day18.mldn.generics;
/**
 * 泛型对象定义：类名称<具体类> 对象名称 － new 类名称<具体类>();
 * 泛型类定义：
［访问权限］ class 类名称<泛型标识1；泛型标识2；泛型标识3；泛型标识4>{
					［访问权限］ 泛型类型标识 变量名称
					［访问权限］  泛型类型标识 方法名称(){};
					［访问权限］ 返回值类型声明 方法名称{泛型类型标识 变量名称){}
 */
/*
 * 代码中的point类声明使用<T>的形式，T表示此类型是由外部调用时指定的。T可以任意取名
 */
public class Point5<T> {//此处可以是任意的标识符号，T是type的简称
	private T var;//此变量的类型由外部决定
	public T getVar(){//返回值的类型由外部指定
		return var;
	}
	public void setVar(T var){//设置的类型由外部指定
		this.var=var;
	}
}
