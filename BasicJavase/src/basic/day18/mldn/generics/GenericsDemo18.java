package basic.day18.mldn.generics;
/**
 * 泛型数组
 *使用泛型方法时，也可以传递或返回一个泛型数组
 */
public class GenericsDemo18 {
	public static void main(String[] args) {
		Integer i[] = fun1(1,2,3,4,5,6);//返回泛型数组
		fun2(i);						//输出数组内容
	}
	public static <T> T[] fun1(T...arg){//接收可变参数，返回泛型数组
		return arg;
	}
	public static <T> void fun2(T param[]){//接收泛型数组
		System.out.print("接收泛型数组：");
		for(T t: param){
			System.out.print(t+",");
		}
		System.out.println();
	}
}
