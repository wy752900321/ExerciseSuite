package basic.day08.practice;

public class EncDemo01 {

	public static void main(String[] args) {
		Person3 per = new Person3();//声明并实例化对象
		per.setName("张三");
//		per.name = "张三";
		per.setAge(-30);
		per.tell();
	}

}
class Person3{
	private String name ;//声明姓名属性
	private int age;//声明年龄属性
	public Person3(){
		
	}
//	public Person3(String name,int age){
//		this.getName(name)=name;
//		this.getAge(Age)=;
//	}
	public void setName(String n){
		name=n;
	}
	public String getName(){
		return name;
	}
	public void setAge(int a){
		if(a>=0&&a<=150){
			age=a;
		}
	}
	public int getAge(){
		return age;
	}
	public void tell(){
		System.out.println("姓名："+name+",年龄："+age);
	}
}