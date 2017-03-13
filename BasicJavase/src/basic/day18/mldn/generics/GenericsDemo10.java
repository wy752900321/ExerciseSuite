package basic.day18.mldn.generics;
/**泛型上限
 *	现在假设一个方法中能接收的泛型对象只能是数字(Byte,Short,Long,Integer,Float,Double)类型，
 *此时在定义方法参数接收对象时，就必须指定泛型的上限。因为所有的数字包装类都是Number类型的子类，所以代码如下： 
 *
 *设置方法只能接收泛型为Number或Number类型的子类
 */
public class GenericsDemo10 {
	public static void main(String[] args) {
		Info<Integer> i1 = new Info<Integer>();//声明Integer的泛型对象
		Info<Float> i2 = new Info<Float>();
		i1.setVar(30);//设置整数，自动装箱
		i2.setVar(30.1f);//设置小数，自动装箱
		fun(i1);//是数字可以传递
		fun(i2);//是小数可以传递
		//编译错，不能传递字符串
//		Info<String> i3 = new Info<String>();//声明String的泛型对象
//		i3.setVar("hello");
//		fun(i3);
	}
	//接收Info对象，范围上限设置为Number,所以只能接收数字类型
	public static void fun(Info<? extends Number> temp){
		System.out.println(temp+",");
	}
}
