package basic.day07;

public class ObjectInitDemo {

	/**对象实例化过程
	 	1 按需加载类（Koo.class)以及所有的父类型，只加载一次！
	 	2 递归调用所有父类构造器（从最高的父类执行A－B－C）
	 		父类中
	 		A 分配父类属性空间，自动初始化为默认值
	 		B 执行属性的初始化赋值
	 		C 执行父类构造器过程
	 	   子类中
	 		D 分配子类属性空间，自动初始化默认值
	 		E 执行子类属性初始化赋值
	 		F 执行子类构造器过程
	 	3 最后创建的对象（子类实例），包含所有父类型声明的属性空间
	 	
	 	this 关键字：
	 		A this() 在构造器的第一行，调用本类的构造器，有this()就不再默认自动添加super()
	 		B this 代表当前对象的引用，用来访问当前对象的属性，和方法
	 			如：this.a 是访问属性
	 			   this.a()是调用方法。
	 				如果能够区别局部变量和属性（实例变量），可以省略掉this.
	 	
	 	super 关键字:
	 		A super()放到构造器的第一行，调用父类构造器，默认自动添加
	 		B super在子类中代表父类型对象的引用，可以用来访问父类型的属性
	 			如：super.a 访问父类型a属性
	 				super.a()访问父类型的方法
	 				如果能够区别当前对象与父类的属性，就可以省略掉super
	 */
	public static void main(String[] args) {
			
		//再看有没有父类型，如有加载，递归加载，按需加载，只加载一次
		K4oo k4oo = new K4oo(10);//先找K4oo.class,通过classpath。如没有发生异常
		System.out.println(k4oo.a);//
	}
}
class F4oo{
	int a =1;
	public F4oo(int a){
		super();
		//分配空间a，初始化变量
		System.out.println("初始化变量a ="+this.a);//1
		this.a = a;
		System.out.println("执行Foo构造器代码a = "+this.a);//8
	}
}
class K4oo extends F4oo{
	int b = 3;
	public K4oo(int b){
		super(8);
		//分配空间b，初始化变量
		System.out.println("Koo(): a="+this.a);//8,super.a也行
		System.out.println("Koo(): b="+this.b);//3
		this.a = b;;
		this.b=b;
		System.out.println("构造器Koo()语句执行：b = "+b);//10
	}
}
