package basic.day14;
/**匿名内部类
 *new Koo()创建本类型对象
 *new Koo(){}创建子类型匿名内部类 
 */
public class AnnInnerClass {
public static void main(String[] args) {
	//new Koo()创建Koo的实例对象
	//new Koo(){}就是匿名内部类，是对Koo类的继承，并且立即
	//实例化为一个对象，这个对象是Koo的子类型（匿名子类型)实例。
	//匿名内部类返回的是对象！其中｛｝是类体，是子类的类体
	//在这个类体中可以实现任何子类型的语法（定义方法，属性，覆盖...), 
	Koo koo = new Koo(){};
	Koo k1 = new Koo(){
		public String toString(){//覆盖父类型的toString()方法
			return "Object k1";
		}
	};
	System.out.println(k1);//Object k1
	//证明了k1引用的实例中的toString()方法被覆盖了，k1引用的是
	//匿名类实例。
	
	//匿名类可以继承(或实现)于类，抽象类或接口
	//在继承(或实现)抽象类或接口时候，要遵守继承的语法
	//必须实现所有的抽象方法！
	//Moo moo = new Moo(){};编译错误，是因为没有没有实现抽象方法
	//"new Moo();"不让用。"new Moo(){}"是匿名内部类，是可以的
	//"new Moo(){}"可以，这不是实例化，这是继承／实现匿名类
	//Moo moo = new Moo();//编译错误，不能实例化接口／抽象类
	final int x = 5;
	Moo moo = new Moo(){
		public int add(int b){//参数类型与方法名
			return b+1;
//			return b+1+x;加变量也要加final类型的
		}
	};
	System.out.println(moo.add(5));
	}
}
interface Moo{
	int add(int a);
}
class Koo{
	
}