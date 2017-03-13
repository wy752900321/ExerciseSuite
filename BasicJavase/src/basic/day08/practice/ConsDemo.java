package basic.day08.practice;

class Person{
	private String name ;
	private int age ;
	public Person(){}					// 声明一个无参的构造方法
	public Person(String n){			// 声明有一个参数的构造方法
		this.setName(n) ;
	}
	public Person(String n,int a){		// 声明构造方法，为类中的属性初始化
		this.setName(n) ;
		this.setAge(a) ;
	}
	public void setName(String n){
		name = n ;
	}
	public void setAge(int a){
		if(a>0&&a<150){
			age = a ;
		}
	}
	public String getName(){
		return name ;
	}
	public int getAge(){
		return age ;
	}
	public void tell(){
		System.out.println("姓名：" + this.getName() + "；年龄：" + this.getAge()) ;
	}
};
public class ConsDemo{
	public static void main(String args[]){
		System.out.println("声明对象：Person per = null ;") ;
		Person per = null ;	// 声明对象时并不去调用构造方法
		System.out.println("实例化对象：per = new Person() ;") ;
		per = new Person("张三",30) ;//实例化对象
		per.tell() ;
	}
};