package basic.day11;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListDemo {
public static void main(String[] args) {
	//List 接口代表抽象的线性表概念，定义线性表的操作方法：如：add()
	//add() remove() size() isEmpty() contains() ....
	//ArrayList 利用Object[] 实现了具体的线性表(list)操作方法
	//add() 在Object[]数组上实现了添加方法
	//ArrayList是利用变长数组算法实现的List(线性表)
	List list = null;//空
	list = new ArrayList();//空集
	System.out.println(list.isEmpty());//看里面有没有元素
	list.add("忐忑");//调用在接口中声明，由ArrayList实现的方法
	list.add("霸王别姬");
	System.out.println(list.isEmpty());//false
	System.out.println(list);//toString();
	
	//LinkedList 是使用“双向循环链表“实现的线性表（list)
	//实现了全部的方法：add()	remove() 等
	//这些方法的底层操作的是“双向循环链表”
	list = new LinkedList();
	list.add("忐忑");
	list.add("霸王别姬");
	System.out.println(list);//[忐忑, 霸王别姬]

}
}
