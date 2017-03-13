package basic.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollectionCopyDemo {
	/**
	 	java只复制第一层不复制第二层。（原则）
	 	浅表复制：是只复制集合对象，不复制集合元素对象
	 	集合类都提供了复制构造器，可以复制集合内容（浅表复制）
	 */
public static void main(String[] args) {
	ArrayList<String> list1 = new ArrayList<String>();
	list1.add("Tom");
	list1.add("Jerry");
	list1.add("Tom");
	
	//clone()可以创建本类型的对象副本
	ArrayList<String> list2 = (ArrayList<String>)list1.clone();
	//是“浅表复制”到结果
	//浅表复制：是只复制集合对象，不复制集合元素对象
	System.out.println("集合相同吗？"+(list1==list2));//false
	System.out.println("元素相同吗？"+(list1.get(0)==list2.get(0)));//true
	
	String[] ary = {"Tom","Jerry"};
	String[] ary1 =Arrays.copyOf(ary, ary.length);
	System.out.println("数组相同吗？"+(ary==ary1));//false
	System.out.println("元素相同吗？"+(ary[0]==ary1[0]));//true
	
	//集合类都提供了复制构造器，可以复制集合内容（浅表复制）
	//new LinkedList<String>(list1) 创建集合是list1的副本
	List<String> linked = new LinkedList<String>(list1);
	System.out.println("集合不同吗？"+(list1==linked));//false
	System.out.println("元素相同吗？"+(list1.get(0)==linked.get(0)));//true
	
	//换类型复制list ->set
	Set<String> set = new HashSet<String>(list1);
	System.out.println(set);//[Jerry, Tom]
	System.out.println(list1);//[Tom, Jerry, Tom]
}
}
