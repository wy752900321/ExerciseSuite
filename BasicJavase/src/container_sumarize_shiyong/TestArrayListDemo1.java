package container_sumarize_shiyong;

import java.util.Vector;
/**
 	执行这个程序可以发现：初始Vector的capacity为10，当元素数量
 	小于capacity时，capacity不会发生变化，但是一旦超过，哪怕超
 	过一个，capacity就会成倍增长。
 */
//测试ArrayList和Vector类的capacity属性
public class TestArrayListDemo1 {
public static void main(String[] args) {
	Vector al = new Vector();
	System.out.println(al.size());//0，实际元素数
	System.out.println(al.capacity());//10，容量，注意ArrayList并不包含次方法
	
	String[] a = new String[11];
	for(int i=0;i<a.length;i++){
		al.add(a[i]);
	}
	System.out.println(al.size());//11，实际元素数
	System.out.println(al.capacity());//20，容量，注意ArrayList并不包含次方法
	}
}
