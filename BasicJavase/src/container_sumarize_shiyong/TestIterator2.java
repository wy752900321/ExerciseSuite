package container_sumarize_shiyong;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/*
 	HashSet
 */
public class TestIterator2 {
public static void main(String[] args) {
	Collection c = new HashSet();
	c.add("孙悟空");
	c.add("猪八戒");
	c.add("沙和尚");
	c.add("唐僧");
	
	//获取c集合对应的迭代器
	Iterator it = c.iterator();
	
	/**
 	正确使用Iterator接口，即迭代周期内，集合元素不能改变。
 */
	while(it.hasNext()){
		String name = (String)it.next();
		System.out.print(name);//唐僧猪八戒孙悟空沙和尚
		if(name.equals("猪八戒")){
			//直接从集合中删除元素，将引发运行时异常＞java.util.ConcurrentModificatrionException
			c.remove(name);
		}
		
		}
	System.out.println(c);
	}
}
