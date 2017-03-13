package basic.day08;

/**
 	静态属性 静态变量
 		A 静态属性是在类加载期间分配，只有一份，属于类的变量
 		B 一般使用类名访问静态属性成员
 	与静态变量相反，实例变量（非静态变量）是属于对象实例的变量每个对象一份
 */
public class StaticFieldDemo {

	public static void main(String[] args) {
		Foo2 f1 = new Foo2();
		Foo2 f2 = new Foo2();
		//静态变量用类名.静态变量名，如：Foo2.index
		System.out.println(f1.id+","+f2.id+","+Foo2.index);//1,2,3
		Foo2 f3 = new Foo2();//1,2,4,3,4
		System.out.println(f1.id+","+f2.id+","+Foo2.index+","+f3.id+","+Foo2.index);
	}

}
class Foo2{
	static int index=1;//静态属性，静态变量
	int id;//实例变量
	public Foo2(){
		this.id = index++;
	}
}
