package connectionDemo;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

	/**
	 * 无序，不重复
	 */
	public static void main(String[] args) {
		Student s1=new Student(1,"tom1");
		Student s2=new Student(2,"tom2");
		Student s3=new Student(3,"tom3");
		Student s4=new Student(4,"tom4");
		
		Set set=new HashSet();
		set.add(s1);
		set.add(s3);
		set.add(s4);
		set.add(s2);
		set.add(s1);
		//循环遍历set集合
		for (Object o : set) {
			System.out.println(o);
		}
	}
}
