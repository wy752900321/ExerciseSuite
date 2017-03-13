package container_sumarize_shiyong;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 	总结：设置不可变集：与同步控制
 */
public class TestCollectionEnd {
	public static void main(String[] args) {
		//创建一个空的不可变集
		List list = Collections.emptyList();
		//创建一个只有一个元素且不可变的Set集合
		Set set = Collections.singleton("java");
		//创建一个普通Map对象
		Map map = new HashMap();
		map.put("语文", 80);
		map.put("Java", 82);
		//返回普通Map对象的不可变版本
		Map uMap = Collections.unmodifiableMap(map);
		//下面任意一行代码都会引发异常：
//		list.add("C++");
//		set.add("C++");
//		uMap.put("数学", 90);
		
		
		//同步控制
		Collection c = Collections.synchronizedCollection(new ArrayList());
		List l = Collections.synchronizedList(new ArrayList());
		Set s = Collections.synchronizedSet(new TreeSet());
		Map m = Collections.synchronizedMap(new HashMap());
	}
}
