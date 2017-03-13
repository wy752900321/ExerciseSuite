package basic.day08;

import basic.day08.sub.Koo;

/**
  	访问修饰：
 		A 公有的属性/方法/类等，在任意地方都可见
 		B 私有的资源（属性/方法/类）只能在类体内部可访问
 		C 保护的资源，在子类，和同一个包(package)可以访问
 		D 默认的（不加关键字的）资源，在同一package中可以访问
 		E 任何访问授权在同一个类内部可以访问
 		
 	编程建议：
 		A 尽可能封装，尽可能减小资源的访问范围
 			优先private,其次protected, 最后public.
 		B 很少使用默认访问授权，很少使用package作为访问范围
 		C 体现面向对象的"封装"特征.
 		D 经常是私有属性,公有属性的访问方法
 		
 	封装：对象尽可能减少对外暴露的现象
 	
 	java源文件规范:
 		A 一个.java文件中可以声明多个类
 		B 一个源文件只能有一个共有类,并且文件名要与公有类类名一致
 			如:Hello.java 与 public class Hello一致
 		C 如果没有公有类,文件名与任意类名一致
 		D 一个类是公有的,其他类就一定是默认修饰的!这就造成:
 			其他的类只能在当前包中访问!访问受限!
 		编程建议:类都是公有的,一个文件一个公有类!
 */
public class AccessDemo {

	public static void main(String[] args) {
		Foo foo = new Foo();
		System.out.println(foo.a);
		System.out.println(foo.b);
		System.out.println(foo.c);
		/*
		 No enclosing instance of type AccessDemo is accessible.Must qualify the allocation with
		 an enclosing instance of type AccessDemo(e.g.x.new A() where x is an instance of AccessDemo
		 */
//		System.out.println(foo.d);//编译错误，封装－－存在d但是不可见。
		System.out.println(foo.getD());//4,说明存在id属性
		
		Koo koo  = new Koo();
		System.out.println(koo.a);//1
//		System.out.println(koo.b);//编译错，b不可见。The field Koo.b not visible.
//		System.out.println(koo.c);//编译错，不可见The field Koo.c not visible.
//		System.out.println(koo.d);//编译错，不可见The field Koo.d not visible.
		System.out.println(koo.getD());//公有方法
		Goo goo = new Goo();
		goo.test();
	}
}
class Goo extends Koo{
	public void test(){
		System.out.println(this.a);//公有，在哪都可见
		System.out.println(this.b);//保护，子类可看见
//		System.out.println(this.c);//默认，子类不可见
//		System.out.println(this.d);//私有，子类不可见
		System.out.println(this.getD());//4
	}
}
class Foo{
	public int a = 1;//公有的
	protected int b = 2;//保护的
	int c = 3;//默认的
	private int d = 4;//私有的
	public int getD(){
		return d;
	}
}

