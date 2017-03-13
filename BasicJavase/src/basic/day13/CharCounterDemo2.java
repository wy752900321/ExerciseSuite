package basic.day13;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



/**
 * 统计字数
 */
public class CharCounterDemo2 {
	public static void main(String[] args) {
		String str = "aabbccderfhhhh";
		Map<Character, Integer> map = countAll(str);
		System.out.println(map);
		//迭代Map:三种
		//迭代Map:迭代所有的key,迭代所有的Value,迭代Entry<key:value>
		//利用迭代所有的value，实现统计所有的字符总数
		Collection<Integer> values = map.values();
		int total = 0;
		Iterator<Integer> ite = values.iterator();
		while(ite.hasNext()){
			Integer n = ite.next();
			total+=n;
		}
		System.out.println("字符总数"+total);
		//迭代所有的key，利用迭代所有字符实现输出统计表格。
		Set<Character> keys = map.keySet();//返回所有的key
		ArrayList<Character> list = new ArrayList<Character>(keys);
		Collections.sort(list);//自然排序／默认排序
		for(Iterator<Character> i = list.iterator();i.hasNext();){
			Character ch = i.next();
			int n  = map.get(ch);
			System.out.println(ch+":");
			System.out.println(n+","+(((double)n/total))*100);
		}
	}

	public static Map<Character, Integer> countAll(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		// 迭代每个字符ch
		for (int i = 0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
			Integer n = map.get(ch);
			map.put(ch, n==null?1:n+1);
//			char ch = str.charAt(i);
//			// 在map中检查是否包含字符ch
//			if (map.containsKey(ch)) {
//				// 如果包含，取出现有值n，取回n+1
//				int n = map.get(ch);
//				map.put(ch, n + 1);
//			} else {// 如果不包含，写入map,1
//				map.put(ch, 1);
//			}
		}
		return map;

	}
}
