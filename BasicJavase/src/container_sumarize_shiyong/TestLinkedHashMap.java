package container_sumarize_shiyong;

import java.util.LinkedHashMap;

public class TestLinkedHashMap {
public static void main(String[] args) {
	LinkedHashMap lhm = new LinkedHashMap();
	lhm.put("语文", 80);
	lhm.put("数学", 70);
	lhm.put("英语", 90);
	//迭代之后按照加入顺序输出
	for(Object key:lhm.keySet()){
		System.out.println(key+"---->");
		System.out.println(lhm.get(key));
	}
}
}
