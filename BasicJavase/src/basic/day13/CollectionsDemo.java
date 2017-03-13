package basic.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class CollectionsDemo {
public static void main(String[] args) {
	List<String> names = new ArrayList<String>();
	names.add("Tom");
	names.add("Andy");
	names.add("Nimo");
	names.add("Jerry");
	names.add("John");
	names.add("Jack");
	System.out.println(names);//[Tom, Andy, Nimo, Jerry, John, Jack]
	Collections.shuffle(names);
	System.out.println("打乱:"+names);//打乱:[John, Jerry, Tom, Andy, Jack, Nimo]
	Collections.sort(names);
	System.out.println("排序："+names);//排序：[Andy, Jack, Jerry, John, Nimo, Tom]
	int index = Collections.binarySearch(names, "Tom");
	System.out.println("二分查找："+index);//二分查找：5
	System.out.println(names);//[Andy, Jack, Jerry, John, Nimo, Tom]
	Collections.fill(names, "佚名");
	System.out.println("填充："+names);//填充：[佚名, 佚名, 佚名, 佚名, 佚名, 佚名]
	

	/**面试
		Collection  VS  Collections
		一个接口，一个类
		Collection 是集合框架的根接口之一，代表基本集合概念的抽象
		定义抽象的集合功能（方法）List和Set都继承于Collection
		Collections 是集合的工具类，提供了集合的工具方法：
		包括：排序，打乱，二分查找，填充等
	 */
}
}
