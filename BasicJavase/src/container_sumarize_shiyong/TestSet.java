package container_sumarize_shiyong;

import java.util.HashSet;
import java.util.Set;

/**
 	set接口：不能重复
 	注意：其实HashSet集合添加元素的原则是：只有equals方法判断相等（返回true），
 	并且hashCode方法返回的值相同时，才无法添加两个同类对象元素，否则，都可以添加。
 */
public class TestSet {
	public static void main(String[] args) {
		//不能重复
		Set s1 = new HashSet();
		s1.add("老虎");
		s1.add("狮子");
		s1.add("老虎");
		System.out.println(s1);//[老虎, 狮子],发现只有一个老虎
		
		//判断重复标准
		Set s = new HashSet();
		Fish f = new Fish("Nemo");
		Fish f1 = new Fish("Melo");
		s.add(f);
		s.add(f1);
		/*
		 	虽然f和f1是两个不同对象，但是因为Fish类的equals方法和hashCode方法的
		 	返回值都相等，所以HashSet认为他们是同一个对象
		 */
		System.out.println(s);//[Nemo]
		System.out.println(f.equals(f1));//true
		System.out.println(f.hashCode(f1));//true
		System.out.println(s.size());//1
	}
}
class Fish{
	private String name;
	public Fish(String name){
		this.name=name;
	}
	public boolean equals(Object o){
		return true;
	}
	public int hashCode(){
		return 1;
	}
	public String toString(){
		return name;
	}
	public boolean hashCode(Object o){
		return this.hashCode()==o.hashCode();
	}
}
