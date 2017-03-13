package basic.day09;

import java.util.Arrays;

public class ObjectDemo3 {
	public static void main(String[] args) {
		Point4  p = new Point4(3,4);
		String str = p.toString();
//		System.out.println(str);//basic.day09.Point4@9304b1
//		System.out.println(p);//basic.day09.Point4@9304b1,java默认调用p.toString()
		System.out.println(str);//（3，4）
		System.out.println(p);//（3，4）
		/**
		  	打印对象信息.Object.toString() 返回全限定名＠hashCode()
		  	全限定名：package.classname
		  	hashCode:是内存地址经过转换得到的一个整数，但不是内存地址
		  	java(sun)建议覆盖掉toString()!
		  	覆盖为对象的文本描述，如（2，3）
		  	很多java API方法调用这个toString（）作为对象的描述
		  	toString()API:返回指定数组内容的字符串表示形式。字符串表示形式由数组的元素列表组成，
		  	括在方括号（"[]"）中.相邻元素用字符 ", "（逗号加空格）分隔
		 */
		Point4[] stars = {new Point4(3,4),new Point4(6,7)};
		System.out.println(Arrays.toString(stars));//[(3,4), (6,7)]
		
		int[] ary = {3,4,5};
		String[] names = {"Tom","Jerry"};
		System.out.println(ary);//[I@190d11
		System.out.println(names);//[Ljava.lang.String;@a90653
		System.out.println(Arrays.toString(ary));//[3, 4, 5]
		System.out.println(Arrays.toString(names));//[Tom, Jerry]
	}
}
class Point4 /** extends Object*/ { //java类默认继承于Object,啥都是东西
	int x ;
	int y;
	public Point4(int x,int y){
		this.x = x;
		this.y = y;
	}
	public String toString(){//覆盖Object的toString()方法
		return "("+x+","+y+")";//(3,4)
	}
}