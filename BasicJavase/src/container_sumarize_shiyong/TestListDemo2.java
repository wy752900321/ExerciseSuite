package container_sumarize_shiyong;

import java.util.ArrayList;
import java.util.List;

//极端情况下演示List判断对象相等标准。
public class TestListDemo2 {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("java");
		l.add("C++");
		l.add("VB");
		System.out.println(l);//[java, C++, VB]
		l.remove(new Aa());
		System.out.println(l);//[C++, VB],将删除第一个元素
		l.remove(new Aa());//还是删除第一个
		System.out.println(l);//[VB]
		
	}
}
class Aa{
	public boolean equals(Object o){
		return true;
	}
}