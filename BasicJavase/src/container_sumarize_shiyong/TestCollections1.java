package container_sumarize_shiyong;

import java.util.ArrayList;
import java.util.Collections;

/*
 	查找／替换
 */
public class TestCollections1 {
public static void main(String[] args) {
	ArrayList al = new ArrayList();
	al.add(2);
	al.add(-5);
	al.add(3);
	al.add(0);
	System.out.println(al);//[2, -5, 3, 0]
	//输出最大元素
	System.out.println("最大元素为："+Collections.max(al));//最大元素为：3
	//输出最小元素
	System.out.println("最小元素为："+Collections.min(al));//最小元素为：-5
	Collections.replaceAll(al, 0, 1);
	System.out.println("替换以后："+al);//替换以后：[2, -5, 3, 1]
	//判断－5出现次数
	System.out.println(Collections.frequency(al, -5));//1
	//排序
	Collections.sort(al);
	System.out.println(al);//[-5, 1, 2, 3]
	//二分法查找
	System.out.println(Collections.binarySearch(al, 3));//3
}
}
