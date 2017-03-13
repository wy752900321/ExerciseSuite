package container_sumarize_shiyong;

import java.util.EnumSet;

public class TestEnumSetDemo {
public static void main(String[] args) {
	//创建一个包含指定元素类型的所有元素的枚举 set。 
	//创建一个EnumSet集合，里面元素就是Season枚举类的全部枚举值
	EnumSet es = EnumSet.allOf(Season.class);
	System.out.println(es);//挨个输出枚举值，发现顺序与枚举类内部定义顺序一致
	//创建一个空的EnumSet集合，里面只允许放入Season枚举值
	EnumSet es1 = EnumSet.noneOf(Season.class);
	es1.add(Season.SPRING);//手动添加
	System.out.println(es1);//[SPRING]
	es1.add(Season.WINTER);
	es1.add(Season.SUMMER);
	System.out.println(es1);//发现尽管先加入winter,但是输出时winter依然在summer之后[SPRING, SUMMER, WINTER]
	
	//指定枚举值的EnumSet集合
	EnumSet es2 = EnumSet.of(Season.SPRING,Season.SUMMER);
	System.out.println(es2);//[SPRING, SUMMER]
	
	//创建一个包含范围的EnumSet集合
	EnumSet es3 = EnumSet.range(Season.SPRING, Season.FALL);
	System.out.println(es3);//[SPRING, SUMMER, FALL]
	
	//创建一个和es3相反的EnumSet集合
	EnumSet es4 = EnumSet.complementOf(es3);
	System.out.println(es4);//[WINTER]
}
}
enum Season{
	SPRING,SUMMER,FALL,WINTER
}