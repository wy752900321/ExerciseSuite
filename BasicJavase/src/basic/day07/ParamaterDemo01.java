package basic.day07;

public class ParamaterDemo01 {

	/**java方法参数传递只有一种方式：基于值的传递
	 * 1.java方法参数传递只有一种方式：基于值的传递,是变量值的复制
	 * 2.基本类型就是其中值的复制
	 * 3.引用类型是引用值（地址）的复制
	 */
	/**程序执行过程
	 * 	1,int a=1放在栈里
	 * 2,值传递（将实参的值传递给形参），传给临时变量add(int a )并放在栈里
	 * 3.执行方法内部代码，a++,上边的临时变量的a++,变成2
	 * 4，方法返回，回收临时变量a=2
	 * 5,调用Koo默认无参构造器，在堆内存中创建对象。调用class Koo，有成员变量放在堆中
	 * 6，将堆内存中对象存储地址赋值给koo = basic.day07.practice.Koo@9304b1
	 * 7,值传递（将实参的首地址传递给形参），放在栈里
	 * 8，进入add(Koo koo)方法，Koo k = koo;放在栈里
	 * 9,k.a++;堆里a++,变成2
	 * 10，add(Koo koo)方法返回，回收临时变量
	 * 11,输出
	 */
	public static void main(String[] args) {
		int a = 1;
		add(a);
		Koo koo = new Koo();
		add(koo);
		System.out.println(a+" ,"+koo.a);//1,2
		System.out.println(koo);;//basic.day07.practice.Koo@9304b1
	}
	public static int add(int a){
		a++;
		return a;
	}
	public static int add(Koo koo){
		Koo k = koo;
		k.a++;
		return koo.a;
	}

}
class Koo{
	int a=1;
}