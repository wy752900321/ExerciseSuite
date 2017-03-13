package basic.day06;

public class ConstructorDemo {

	/**
	 * A 类一定有构造器
	 * B 如果没有提供构造器，javac默认添加默认构造器
	 * C 如果声明了构造器，javac就不再添加任何构造器
	 */
	public static void main(String[] args) {
		Foo foo = new Foo();//调用黑夜构造器
//		Koo koo = new Koo();//编译错误，没有构造器Koo();
		Koo k2 = new Koo(1);//有构造器，Koo（int)
//		System.out.println(koo.a);//编译错误
	}
}
class Foo{
	//public Foo(){}
}
class Koo{
	int a ;
	public Koo(int a){
		this.a = a;
	}
}
