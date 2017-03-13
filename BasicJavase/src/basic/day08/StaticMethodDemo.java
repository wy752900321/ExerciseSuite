package basic.day08;

public class StaticMethodDemo {

	/**
	 	静态方法是属于类的方法，不需要创建类的实例，可以直接调用的方法
	 	非静态方法，依赖于对象，要使用对象调用，并且方法内部的this是
	 	对调用方法当前对象的引用
	 */
	public static void main(String[] args) {
		//静态方法没有this，不能用this.调用变量
		int x = Goo2.add(2,3);//6,2+3+1=6，用类名调用静态方法
		Goo2 goo = new Goo2();//用对象调用非静态方法
		//调用非静态方法，就是把add(goo,5),的goo赋值
		//给add(/*Goo2 this*/int a)的Goo2 this，把5赋值给add(/*Goo2 this*/int a)的int a
		int y = goo.add(5);//6,1+5=6,add(goo,5);goo引用隐含传递给this!
	}

}
class Goo2{
	int a =1;
	static int b = 1;
	public static int add(int a,int b){//静态方法，类的方法
//		return add(1);//编译错误，隐含this，静态中没有this.
//		return this.add(1,2);//编译出错，因为静态中没有this
		return a+b+Goo2.b;
	}
	public int add(/*Goo2 this*/int a){//非静态方法，对象的方法
		return this.a+a;
	}
}