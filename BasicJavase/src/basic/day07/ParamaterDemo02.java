package basic.day07;

public class ParamaterDemo02 {

	/**案例2 演示在java中的值传递过程
	 	1.基本类型的值是其本身
	 	2.引用变量的值是一个地址值，是被引用对象的首地址
	 	3.为了避免引用参数传递的副作用，建议一切结果使用返回值带回
	 */
	public static void main(String[] args) {
		int a = 1;
		int c = add(a);
		KKoo koo = new KKoo();
		int d =  add(koo);
		System.out.println(a+","+koo.a);
		System.out.println(c+","+d);
	}
	public static int add(int a){
		a++;
		return a;
	}
	public static int add(KKoo koo){
		KKoo k = koo;
		k.a++;
		return koo.a;
	}
}
class KKoo{
	int a = 1;
}