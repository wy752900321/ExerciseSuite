package basic.day08.practice;

public class NonameDemo01 {

	public static void main(String[] args) {
		new Person2("张三",30).tell() ;//就可以少分一个栈内存
	}

}
class Person2{
	private String name ;
	private int age ;
	public Person2(String n,int a){		// 声明构造方法，为类中的属性初始化
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