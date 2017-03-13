package basic.day12;

import java.util.HashMap;

/*
 	HashMap
 */
public class HashMapDemo1 {
public static void main(String[] args) {
	HashMap hotel = new HashMap();//默认容量16加载因子75％，门槛数量
	hotel.put("tom", 5);//加入key:value,根据key计算hash位置
	//这个位置就是存储数组中的位置
	hotel.put("Jerry", 5);//key是关键字，不能重复，value可以重复
	hotel.put("Andy", 2);
	hotel.put("Robin", 1);
	hotel.put("Mac", 3);//第一次是添加
	hotel.put("Mac", 9);//第二次是覆盖！重复的key算同一个
	System.out.println(hotel.size());//5
	//get(key)方法就是根据key计算散列值查找value过程
	int age = (Integer)hotel.get("Mac");//9
	System.out.println(age);
	
	System.out.println(hotel.containsKey("Tom"));//true
	System.out.println(hotel.containsValue(5));//true
	System.out.println(hotel.containsValue(3));//false
	//返回全部的（key:value)对的集合
	System.out.println(hotel.entrySet());//[Jerry=5, Mac=9, Robin=1, tom=5, Andy=2]
	System.out.println("全部key:"+hotel.keySet());//全部key:[Jerry, Mac, Robin, tom, Andy]
	System.out.println("全部value:"+hotel.values());//全部value:[5, 9, 1, 5, 2]
	
	hotel.remove("Mac");
	System.out.println(hotel.size());//4
	System.out.println(hotel.isEmpty());//false
	System.out.println(hotel);//{Jerry=5, Robin=1, tom=5, Andy=2}
	
	hotel.clear();
	System.out.println(hotel.size());//0
	System.out.println(hotel.isEmpty());//true
	System.out.println(hotel);//{}

}
}
