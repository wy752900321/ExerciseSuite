package basic.day18.mldn.generics;
/**通过泛型方法返回泛型实例
 *	如果可以通过泛型方法返回一个泛型类的实例化对象，
 *	则必须在方法的返回类型声明处明确地指定泛型标识  
 */
class Info6<T extends Number>{	//此处泛型只能是数字类型
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
public class GenericsDemo16 {
	public static void main(String[] args) {
		Info6<Integer> i = fun(30);
		System.out.println(i.getVar());
	}
	//<T extends Number>指：方法中传入或返回的泛型类型由调用方法时所设置的参数类型决定 
	public static <T extends Number> Info6<T> fun(T param){
		Info6<T> temp = new Info6<T>();//根据传入的数据类型实例化Info6对象
		temp.setVar(param);//将传递的内容设置到Info6类中的var属性之中
		return temp;//返回实例化对象
	}
}
