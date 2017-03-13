package basic.day18.mldn.generics;
/**
 * 定义子类方式1－－在子类的定义上声明泛型类型
 * 与GenericsDemo13.java相关联
 */
interface Info4<T> {//在接口上定义泛型 
	public T getVar();
}
class InfoImpl<T> implements Info4<T>{//定义泛型接口的子类
	private T var;
	
	public InfoImpl(T var){
		this.setVar(var);
	}
	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
	
}