package basic.day08;
/**
 	静态绑定：java根据引用变量类型查找属性
 	动态绑定：java根据实际的对象查找方法
 	  在 Student 对象中有 2 个属性 name，系统为了加以区分，会为同名属性加一个标签：将属性标记
为在栈内存中声明的引用变量的类型，调用具体引用变量.属性时，根据标签去找，这种现象称为静态绑定
注意：本案例在业务上丌合理，在开发过程中极少会遇到子类和父类定义同名属性的情况，所以建议：所有属性使用方法访问
在 Java 中将这种建议的规范总结出一套，我们称之为“JavaBean 规范”。
  关于 JavaBean 规范：JavaBean 丌是语法规范，是习惯性编程规范，用这个规范写的类使用方便。
有时候 JavaBean 的类也称为:POJO 类（Plan Old Java Object）
  简化规范：
  1)   必须有包（package）
  2)   Java 类，具有无参数构造器
  3)   有用 getXxx() 和 setXxx() 声明的 Bean 属性
            如：getName() 和 setName(String n) 声明的 Bean 属性为：name, 不是否有实例变量name无关
            boolean 类型的 get 方法可以有两种形式：getMarried() 或者 isMarried()
  4)   必须实现序列化接口（注：在学习 IO 的时候具体学习）
  JDK 提供的类几乎都符合 JavaBean 规范。如：String 类, 集合类
  JavaBean 最大的好处：“使用方便”

 */
public class FieldDemo {

	public static void main(String[] args) {
		Student tom = new Student("Tom Wang");
		System.out.println(tom.name);
		Person5 p = tom;
		System.out.println(p.name);
	}

}
class Person5{
	String name;
}
class Student extends Person5{
	String name;
	public Student(String name){
		this.name=name;
		super.name="p"+name;
	}
}