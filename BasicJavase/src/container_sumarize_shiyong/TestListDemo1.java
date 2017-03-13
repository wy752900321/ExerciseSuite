package container_sumarize_shiyong;

import java.util.ArrayList;
import java.util.List;

/*
 	List集合
 	注意此例中，判断位置的语句，使用了new操作符，也就是说判断的内容是一个新字符串
 	对象，这一个对象肯定不包含在List集合中，那么为什么会返回2呢？
 	这是因为在List中判断两个对象是否相等的标准为equals返回true
 */
public class TestListDemo1 {
	public static void main(String[] args) {
		List l = new ArrayList();
		l.add("java");
		l.add("C++");
		l.add("VB");
		System.out.println(l);//[java, C++, VB]，按顺序输出
		
		l.add(1, "Delphi");
		System.out.println(l);//[java, Delphi, C++, VB]
		
		//显示第三个元素
		System.out.println(l.get(2));//C++
		
		//删除第二个元素
		l.remove(1);
		System.out.println(l);//[java, C++, VB]
		//判断指定元素在集合中的位置
		System.out.println(l.indexOf(new String("VB")));//2,注意此处
		//将第二个元素替换换成新对象
		l.set(1, "VFP");
		System.out.println(l);//[java, VFP, VB]
		//显示第一个(包含)到第三个元素（不包含）
		System.out.println(l.subList(0, 2));//[java, VFP]
	}
}
