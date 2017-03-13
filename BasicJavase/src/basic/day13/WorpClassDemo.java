package basic.day13;

import java.util.Scanner;

/**包装类*/
public class WorpClassDemo {
public static void main(String[] args) {
	//char[]	String
	//int 		Integer
	int i = 1;
	Integer x = new Integer(1);//包装,boxing
	Object o = x;//将基本类型包装为对象。
	int j = x.intValue();//拆包，unboxing
	System.out.println(j);//1
	
	Integer y = 5;//java 5 自动包装，java在底层调用new Integer(5）；
	int z = y+6;//底层计算方式：y.intValue()+6;自动拆包
	Integer n = y + 6;//自动包装，与拆包，会遭成性能下降
	int m = i+6;//性能高
	
	//基本类型的工具方法，与基本类型输入输出相关
	//基本类型＜－＞String
	Scanner in = new Scanner(System.in);
	int k = in.nextInt();//Integer.parseInt(str)
	String str = "65";
	k = Integer.parseInt(str);//"65"->65
	System.out.println(k);
	
	k = 0xffffffff;
	System.out.println(k);
	System.out.println(Integer.toString(k));//-1
	
	double d = -1;
	System.out.println(Double.toString(d));
	
	boolean b = true;
	System.out.println(Boolean.toString(b));//"true"
	}
}