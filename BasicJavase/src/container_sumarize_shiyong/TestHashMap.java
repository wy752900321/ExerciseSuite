package container_sumarize_shiyong;

import java.util.HashMap;
import java.util.Hashtable;

/**HashMapo类和Hashtable类
 	将null放入map,可以。Hashtable不能加空元素
 */
public class TestHashMap {
public static void main(String[] args) {
	HashMap hm = new HashMap();
	//试图将两个key为null的键值对放入集合
	hm.put(null, null);
	hm.put(null, null);//没有放入成功
	System.out.println(hm.size());//1
	hm.put("a", null);
	System.out.print(hm);//{null=null, a=null}
	
	Hashtable ht = new Hashtable();
	ht.put(null, null);//引发空指针异常
	System.out.println(ht);
}
}
