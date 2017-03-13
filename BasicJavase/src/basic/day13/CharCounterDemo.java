package basic.day13;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计字数
 */
public class CharCounterDemo {
	public static void main(String[] args) {
		String str = "aabbccderfhhhh";
		Map<Character, Integer> map = countAll(str);
		System.out.println(map.toString());
	}

	public static Map<Character, Integer> countAll(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		// 迭代每个字符ch
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			// 在map中检查是否包含字符ch
			if (map.containsKey(ch)) {
				// 如果包含，取出现有值n，取回n+1
				int n = map.get(ch);
				map.put(ch, n + 1);
			} else {// 如果不包含，写入map,1
				map.put(ch, 1);
			}
		}
		return map;

	}
}
