package basic.day18.mldn.generics;
/**
 *泛型的嵌套设置 
 */
public class GenericsDemo19 {
	public static void main(String[] args) {
		Demo2<Info8<String,Integer>> d = null;//将Info8作为Demo2的泛型类型
		Info8<String,Integer> i = null;//Info要指定两个泛型类型
		i = new Info8<String,Integer>("贾东坡",20);
		d = new Demo2<Info8<String,Integer>>(i);//在Demo类中设置Info类对象
		System.out.println("内容一："+d.getInfo().getVar());
		System.out.println("内容二："+d.getInfo().getValue());
	}
}
class Info8<T,V>{//指定两个泛型类型
	private T var;//第一个泛型属性
	private V value;//第一个泛型属性
	
	public Info8(T var,V value) {//通过构造方法设置
		this.setVar(var);
		this.setValue(value);
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public T getVar() {
		return var;
	}
	public void setVar(T var) {
		this.var = var;
	}
}
class Demo2<S>{
	private S info;

	public Demo2(S info) {
		this.setInfo(info);
	}

	public S getInfo() {
		return info;
	}

	public void setInfo(S info) {
		this.info = info;
	}
	
}