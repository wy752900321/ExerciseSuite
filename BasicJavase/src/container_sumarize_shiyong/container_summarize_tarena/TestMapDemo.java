package container_sumarize_shiyong.container_summarize_tarena;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class TestMapDemo {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("c++", "chenglong");
		map.put("corejava", "huxz");
		map.put("java web", "qiaxf");
		map.put("ejb", "zhuzh");
		// System.out.println(map);//{ejb=zhuzh, c++=成龙, corejava=huxz, java
		// web=jiaxf}
		// 返回的是上一次此KEY对应的值，没有，为null.
		// 如果KEY相同，则替换，返回旧值
		System.out.println(map.put("c++", "wangfei"));//chenglong
		// System.out.println(map);//{ejb=zhuzh, c++=wangfei, corejava=huxz, java
		// web=jiaxf}
		System.out.println(map.get("c++"));// wangfei
		System.out.println("===============================");
		printValue(map);
		System.out.println("=================================");
		printKeyValuePairs(map);
		System.out.println("================================");
		printWithEntrySet(map);
	}

	// 迭代方式一 key
	public static void printValue(Map m) {
		Collection c = m.values();// value返回此映射的值
		Iterator it = c.iterator();
		while (it.hasNext()) {
			String s = (String) it.next();
			// 映射顺序 定义为迭代器在映射的 collection 视图上返回其元素的顺序
			System.out.println(s);
		}
	}
	//迭代方式二 key-value
	public static void printKeyValuePairs(Map m){
		Set s = m.keySet();//拿到所有Key的set集合
		Iterator it = s.iterator();
		while(it.hasNext()){
			String key =(String)it.next();
			//get(Object key) 返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
			String value =(String)m.get(key);
			System.out.println(key+"-----"+value);
			
		}
	}
	//迭代方式三：key-value
	public static void printWithEntrySet(Map m){
		Set s =m.entrySet();//拿到的是：键值对关系（Entry）的set集合
		Iterator it = s.iterator();
		while(it.hasNext()){
			Entry element = (Entry)it.next();
			String key =(String)element.getKey();
			String value =(String)element.getValue();
			System.out.println(key+"<====>"+value);
		}
	}
}
