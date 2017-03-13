package basic.day08;

/**
 	静态代码块，在类的加载期间执行，类只加载一次，所以只执行一次
 	非静态代码块，在创建时候执行，每创建一个对象就执行一次
 */
public class StaticStatementDemo {

	public static void main(String[] args) {
		Xoo x1 = new Xoo();
		Xoo x2 = new Xoo();
	}

}
class Xoo{
//	System.out.println("HI");//出错，不能在类体中。
	{
//		System.out.println("HI");//没错了，放在类体的块里中。
		System.out.println("非静态代码块");
	}
	static {
		System.out.println("静态代码块");
	}
	public Xoo(){
		System.out.println("执行构造器！");
	}
}
/**输出如下：
 	静态代码块
	非静态代码块	
	执行构造器！
	非静态代码块
	执行构造器！
 */