package container_sumarize_shiyong;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 	treeMap
 */
public class TreeMapDemo {
public static void main(String[] args) {
	//key的类型是String,Value是int，使用包装类
	//TreeMap 按照key的大小创建排序二叉树结构。
	Map<String,Integer> map = new TreeMap<String,Integer>();
	map.put("Tom", 5);
	map.put("Jerry", 2);
	map.put("Andy", 4);
	map.put("Robin", 5);
	map.put("Wang", 5);
	System.out.println(map);
	System.out.println(map.get("Tom"));//5
	
	//TreeSet 底层就是TreeMap,相当于保留key部分的treeMap
	TreeSet<String> set = new TreeSet<String>();
	set.add("Tom");
	set.add("Andy");
	set.add("Jerry");
	System.out.println(set);
}
}
