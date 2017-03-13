package basic.day08;

/**
 	final类不能被继承，不能有子类了
 	Spring Struts2 Hibernate框架使用了技术：动态代理技术
 	动态代理的原理：就是继承系统中的java bean并且覆盖所有方法
 	final 类会阻止继承 干拢动态代理技术
 	
 	建议不使用final类！
 	
 	Java API有final类：String Integer Double 等包装类
 */
public class FinalClassDemo {

	public static void main(String[] args) {
	}

}
//class MyString extends String{}//编译错误，String是final类
class Koo{
}
final class Foo3 extends Koo{
}
//class Goo extends Foo3{}//编译错误