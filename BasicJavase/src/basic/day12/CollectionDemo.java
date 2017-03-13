package basic.day12;

import java.util.Collection;
import java.util.Set;
import java.util.List;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ArrayList;
/*
 * set:没有顺序，不可重复，像数学的集合
	list:有顺序，并可以重复
	两个对象的地址一定不一样，那怎样判断是否重复呢？
	判断可重复原则：如果两个对象互相的equals就就可以说他们重复了
	父类的引用指向子类对象
 */
public class CollectionDemo {

	public static void main(String[] args) {
		//集合，元素放到一起就可以了，没有定义序号(index)
		Collection<String> col = new LinkedList<String>();
		col.add("Tom");
		col.add("Andy");
		col.add("Jerry");
//		String str = col.get(1);//编译错误,col上没有方法get(index)
		System.out.println(col);//[Tom, Andy, Jerry]
		
		//Set是数学集合，元素不能重复，元素无序
		//HashSet使用HashMap实现的set,只保留了key部分
		Set<String> set = new HashSet<String>();
		set.add("Tom");
		set.add("Jerry");
		set.add("Andy");
//		System.out.println(set.get(1));//编译错误,set没有方法get(index),因为set本身就是无序的
		System.out.println(set);//结果与添加顺序无关。[Jerry, Tom, Andy]
		
		//List集合是有顺序，元素可以重复，有Index相关的方法
		List<String> list = new ArrayList<String>();
		list.add("Tom");
		list.add("Jerry");
		list.add("Andy");
		list.add("Tom");
		System.out.println(list.get(1));//Jerry
		System.out.println(list);//[Tom, Jerry, Andy, Tom]
	}

}
