package connectionDemo;

import java.util.ArrayList;
import java.util.List;

public class ArryListDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Student s1=new Student(1,"tom1");
		Student s2=new Student(2,"tom2");
		Student s3=new Student(3,"tom3");
		Student s4=new Student(4,"tom4");
		
		
		List list=new ArrayList();
		list.add(s2);
		list.add(s1);
		list.add(s4);
		list.add(s3);
		list.add(s1);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
}
