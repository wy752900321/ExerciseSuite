package basic.day07;

/**
	A 类一定有构造器
	B 子类不能继承父类构造器
	C 子类一定调用父类构造器
		默认调用父类型无参数构造器
		或都使用super()调用父类构造器
	D 面试题：
		子类默认调用父类构造器，先输出的是Call Xoo(),后输出Call Yoo()
		调用父类的无参数构造器，是javac默认自动添加的
	F 编程建议：所有类都提供无参数构造器!方便继承中子类默认调用!
*/
public class ConstructorDemo {

	public static void main(String[] args) {
//		Goo goo = new Goo(1);//编译错误，构造器不能继承。
		Goo goo = new Goo();//不是继承的，new Goo()调用的是子类默认构造器
		Yoo yoo = new Yoo();//子类构造器默认调用父类构造器！
		new B();//选D
		//选择输出结果：A 编译错 B 运行异常 C 无 D.A
		/**输出：
	 	A
		basic.day07.B@1fb8ee3
		 */
	System.out.println(new B());
	}

}
class A{
	public A(){
		System.out.println("A");
	}
}
class B extends A{
	
}
class Noo{
	public Noo(int a){}//子类出错
}
class Moo extends Noo{//编译错误，没有办法默认调用父类无参数构造器
	public Moo(){
		super(5);//使用super(int),调用父类有参数构造器
	}
	public Moo(int x){
		this();//如果有this()，javac就不添加super()
		//通过this()调用Moo()在Moo()中最终也调用的父类构造器
	}
}
class Xoo{
	public Xoo(){
		System.out.println("Call Xoo()");
	}
}
class Yoo extends Xoo{
	public Yoo(){
		//super()必须出现在代码的第一行！
		super();//调用父类的无参数构造器，是javac默认自动添加的
		System.out.println("Call Yoo()");
		}
}
class Foo{
	int a;
	public Foo(){
	}
	public Foo(int a){
		this.a = a;
	}
}
class Goo extends Foo{
	
}
