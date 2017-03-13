package container_sumarize_shiyong;

import java.util.Comparator;
import java.util.TreeSet;

/**两种方法定制排序：
	第二种：使用Comparator接口
*/
public class TestTreeSetDemo5 {
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
class Teacher{
	private String name;
	private int age;
	private double height;
	public Teacher(String name,int age,double height){
		this.name = name;
		this.age = age;
		this.height = height;
	}
	public boolean equals(Object o){
		Teacher s = (Teacher)o;
		if(this.name.equals(s.name)&&this.age ==s.age && this.height==s.height){
			return true;
		}
		return false;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public double getHeight(){
		return height;
	}
	public void setHeight(double height){
		this.height=height;
	}
	public int hashCode(){
		return age;
	}
	public String toString(){
		return name;
	}
}
//comparator接口：int compare(Object o1,Object o2);对两个对象比较。分别返回：0，-1，1
class TeacherComparator implements Comparator{
	public int compare(Object o1,Object o2){
		Teacher t1 = (Teacher)o1;
		Teacher t2 = (Teacher)o2;
		if(t1.getHeight()>t2.getHeight()){
			return 1;
		}
		else if(t1.getHeight()<t2.getHeight()){
			return -1;
		}
		else{
			return 0;
		}
	}
}