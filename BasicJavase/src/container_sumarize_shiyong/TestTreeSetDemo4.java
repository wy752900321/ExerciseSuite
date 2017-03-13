package container_sumarize_shiyong;

import java.util.TreeSet;

/**两种方法定制排序：
 	第一种：实现Comparable接口
 */
public class TestTreeSetDemo4 {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		Student s1 = new Student("孙悟空",500,175);
		Student s2 = new Student("猪八戒",200,180);
		Student s3 = new Student("沙和尚",150,185);
		Student s4 = new Student("唐僧",40,176);
		ts.add(s1);
		ts.add(s2);
		ts.add(s3);
		ts.add(s4);
		System.out.println(ts);//自动按身高来排序
	}
}
class Student implements Comparable{
	private String name;
	private int age;
	private double height;
	public Student(String name,int age,double height){
		this.name = name;
		this.age = age;
		this.height = height;
	}
	/*
	 * comparable接口的compareTo(Object o)：比较当前实例对象与对象
	 * .如果位于对象o之前，则返回负值；如果两个对象在排序中位置相同，返回0；
	 * 如果位于对象o后面，则返回正值。
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o){//重写compareTo方法，按照height来比较
		Student s = (Student)o;
		if(this.height>s.height){
			return 1;
		}
		else if(this.height<s.height){
			return -1;
		}
		else {
			return 0;
		}
	}
	public boolean equals(Object o){
		Student s = (Student)o;
		if(this.name.equals(s.name)&& this.age == s.age && this.height ==s.height){
			return true;
		}
		return false;
	}
	public int hashCode(){
		return age;
	}
	public String toString(){
		return name;
	}
}