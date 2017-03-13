package basic.day08.sub;

class Person{
	String name ;		// 声明姓名属性
	int age ;			// 声明年龄属性
	public void tell(){	// 取得信息
		System.out.println("姓名：" + name + "，年龄：" + age) ;
	}
};
public class ClassDemo02{
	public static void main(String args[]){
		Person per1 = null ;		// 声明对象
		Person per2=null;
		per1= new Person() ;	// 实例化对象
		per2 = per1;
		per1.name="张三";
		per1.age=30;
		per2.age=33;
		System.out.println("per1对象的内容：");
		per1.tell();
		System.out.println("per2对象的内容：");
		per2.tell();
	}
};