package container_sumarize_shiyong;

import java.util.TreeSet;

/**
 	TreeSet集合添加元素的极端情况：
 */
public class TestTreeSetDemo3 {
	
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		Z z = new Z("AAA");
		ts.add(z);
		ts.add(z);
		System.out.println(ts);//[AAA, AAA]
		((Z)ts.first()).name = "BBB";//修改第一个元素的name属性
		System.out.println(ts);//[BBB, BBB],发现两个元素的name属性同时改变，因为它们本身就是一个对象
	}
}
class Z implements Comparable{
	String name;
	public Z(String name){
		this.name = name;
	}
	public boolean equals(Object o){
		return false;
	}
	public int compareTo(Object o){
		return 1;
	}
	public String toString(){
		return name;
	}
}