package basic.day09;

/**final 关键字 
		1)  final 修饰的类，不能再被继承
		         Java 的 String 就是 final 类，不能被继承！（面试题可能考到）
		         Math 是 final 类，不能被继承！
		         Integer 、Long、Character 等包装类是 final 类，不能被继承！
		         在实际项目开发中，原则上不允许使用 final 类！
		         Spring, Hibernate,Struts 2, 这些框架使用了"动态继承代理"技术，使用 final 的类会影
		          响"动态代理技术" 的实现.
		2)  final 修饰的方法，不能再被覆盖
		         在实际项目开发中，原则上不允许使用 final 方法！ 原因也是因为: 动态代理技术
		3)  final 修饰的变量，初始化以后不允许再修改了
		         final 局部变量
		         final 方法参数
		         final 的成员变量
		4) final static -- Java 使用 final static 修饰的变量作为常量
		        一般要求常量名都有大写字母
		        Java 常量不是 const（c、c++中修饰常量的修饰符）
		 
 */
public class FinalFieldDemo {

	public static void main(String[] args) {
		Goo g1 = new Goo();
		Goo g2 = new Goo();
		System.out.println(g1.id+","+g2.id+","+Goo.index);//1,2,3
//		g1.id = 8;//编译错误，id可以初始化，不能再修改
	}

}
class Goo{
	static int index =1;
	final int id;
	public Goo(){
		this.id = index++;
	}
}
