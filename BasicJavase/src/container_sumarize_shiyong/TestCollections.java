package container_sumarize_shiyong;

import java.util.Collections;
import java.util.ArrayList;

/*
 	Collections工具类
 */
public class TestCollections {
public static void main(String[] args) {
	ArrayList al = new ArrayList();
	al.add(2);
	al.add(-5);
	al.add(3);
	al.add(0);
	System.out.println(al);//[2, -5, 3, 0]
	//反转
	Collections.reverse(al);
	System.out.println("反转以后：");
	System.out.println(al);//0, 3, -5, 2]
	//排序
	Collections.sort(al);
	System.out.println("排序以后：");
	System.out.println(al);//[-5, 0, 2, 3]
	//洗牌
	Collections.shuffle(al);
	System.out.println(al);//变化的数组
}
}
