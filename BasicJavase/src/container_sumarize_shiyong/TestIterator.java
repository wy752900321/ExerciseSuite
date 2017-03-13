package container_sumarize_shiyong;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 	使用Iterator接口迭代并修改集合
 */
public class TestIterator {
public static void main(String[] args) {
	Collection c = new HashSet();
	c.add("孙悟空");
	c.add("猪八戒");
	c.add("沙和尚");
	c.add("唐僧");
	
	//获取c集合对应的迭代器
	Iterator it = c.iterator();
	while(it.hasNext()){
		//it.next()方法返回的是Object类型，需要强制类型转换
		String name = (String)it.next();
		System.out.print(name);//唐僧猪八戒孙悟空沙和尚
		if(name.equals("猪八戒")){
			//从集合中删除上一次next方法返回的元素
			it.remove();//[唐僧, 孙悟空, 沙和尚]
		}
	}
	System.out.println("\n"+c);

  }
	
}
