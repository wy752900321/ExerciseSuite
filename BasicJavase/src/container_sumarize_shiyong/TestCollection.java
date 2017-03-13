package container_sumarize_shiyong;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestCollection {
public static void main(String[] args) {
	Collection c = new ArrayList();
	//添加元素
	c.add("孙悟空");
	//由自动装功能给集合放入基本数据类型
	c.add(9);
	System.out.println("集合C中的元素个数为："+c.size());//2
	//判断集合中是否包含某个元素
	System.out.println("集合C中是否包含孙悟空："+c.contains("孙悟空"));//集合C中是否包含孙悟空：true
	
	c.add("猪八戒");
	
	Collection c1 = new HashSet();
	c1.add("猪八戒");
	c1.add("沙和尚");
	//判断一个集合内是否包含另一个集合的全部元素
	System.out.println("C是否包含c1全部元素："+c.contains(c1));//C是否包含c1全部元素：false
	
	System.out.println("C："+c);
	System.out.println("C1："+c1);
	//用C集合减去c1集合里的元素
	c.remove(c1);
	System.out.println("c的元素为："+c);//c的元素为：[孙悟空, 9, 猪八戒]
	
	//删除c集合内的全部元素
	c.clear();
	System.out.println("C的元素为："+c);//C的元素为：[]
	c.add("沙和尚");
	System.out.println("c1集合的元素为："+c1);//c1集合的元素为：[猪八戒, 沙和尚]
	//c1集合里只剩下C集合里也包含的元素
	c1.retainAll(c);//保存相同的
	System.out.println("c1集合的元素为："+c1);//c1集合的元素为：[沙和尚]

	
	
}
}
