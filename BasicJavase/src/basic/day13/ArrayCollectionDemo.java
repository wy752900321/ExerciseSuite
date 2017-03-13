package basic.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/** 数组与集合的相与转换*/
public class ArrayCollectionDemo {
public static void main(String[] args) {
	//数组到集合的转换
	String[] names = {"Tom","Jerry","Tom"};
	//asList()方法可以将数组转换为List集合对象，这个list是只读的
	List<String> list = Arrays.asList(names);
	System.out.println(list.get(1));//Jerry
//	list.add("Andy");//运行异常
//	list = (ArrayList<String>)list;//运行异常，不可以强制转换
	//转list
	list = new ArrayList<String>(list);//新建一个，可以的
	System.out.println(list);//[Tom, Jerry, Tom]
	//转成set
	Set<String> set = new HashSet<String>(list);
	System.out.println(set);//[Jerry, Tom]
	
	//集合转换为数组
	//toArray()是转换为Object[]类型数组
	Object[] ary = set.toArray();
	System.out.println(Arrays.toString(ary));//[Jerry, Tom]
	//toArray(ary)是转换为特定类型的数组，如：String[]类型
	String[] ary1 = new String[4];
	/**
	 set.toArray(ary1)尽可能将set中的元素填充到ary1中
	 	如果：ary1 容量够用，就填充并且返回ary1对象
	 	如果：ary1 容量不够用，就创建新数组填充并且返回新数组
	 */
	ary1 = set.toArray(ary1);
	String[] ary2 = new String[1];
	ary2 = set.toArray(ary2);
	System.out.println(Arrays.toString(ary1));//[Jerry, Tom, null, null]
	System.out.println(Arrays.toString(ary2));//[Jerry, Tom]

	//手工转
	String[] ary3 =new String[set.size()];
	int j =0;
	for(Iterator<String> i =set.iterator();i.hasNext();){
		ary3[j++]=i.next();
	}
	System.out.println(Arrays.toString(ary3));//[Jerry, Tom]
}
}
