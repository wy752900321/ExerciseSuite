package basic.day14;

import basic.day14.Foo.Koo;

public class StaticInnerClassDemo {

	public static void main(String[] args) {
		Koo koo = new Koo();
		System.out.println(koo.add());
	}
}
class Foo{
	int a = 1 ;
	static int b = 5;
	//静态内部类可以访问外部类的静态成员
	static class Koo{//静态内部类
		//静态内部类不可以访问内部非静态成员
		int b = 1;
		public int add(){
			//return a+b;//编译错误。没有a.Cannot make a static reference to the non-static field a 
			return Foo.b+b;
		}
	}
}