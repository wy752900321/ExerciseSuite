package basic.day18.mldn.generics;
/**
 * 使用泛型 统一传入的参数类型
 * add()中两具info对象的泛型类型必须一致。
 */
class Info7<T>{	//此处泛型只能是数字类型
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
public class GenericsDemo17 {
	public static void main(String[] args) {
		Info7<String> i1 = new Info7<String>();//设置String为泛型类型
		Info7<String> i2 = new Info7<String>();
		i1.setVar("HELLO");//设置内容
		i2.setVar("贾东坡");
		add(i1,i2);
	}
	public static <T> void add(Info7<T> i1,Info7<T> i2){
		System.out.println(i1.getVar()+" "+i2.getVar());
	}
}
