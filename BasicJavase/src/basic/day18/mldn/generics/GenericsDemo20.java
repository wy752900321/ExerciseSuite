package basic.day18.mldn.generics;

public class GenericsDemo20 {
	public static void main(String[] args) {
		Person<Contact> per = null;//声明Person对象，同时指定Contact类型
		//实例化Person对象，同时设置info的信息
		per = new Person<Contact>(new Contact("北京市","01051283346","100088"));
		System.out.println(per);
	}
}
