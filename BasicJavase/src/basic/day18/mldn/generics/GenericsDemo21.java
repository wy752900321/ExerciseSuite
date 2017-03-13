package basic.day18.mldn.generics;

public class GenericsDemo21 {
	public static void main(String[] args) {
		Person<Introduction> per = null;//声明Person对象，同时指定Introduction类型
		//实例化Person对象，同时设置info的信息
		per = new Person<Introduction>(new Introduction("贾东坡","男",30));
		System.out.println(per);
	}
}
