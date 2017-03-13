package container_sumarize_shiyong;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
public static void main(String[] args) {
	HashSet hs = new HashSet();
	LinkedHashSet lhs = new LinkedHashSet();
	hs.add("一");
	lhs.add("一");
	hs.add("二");
	lhs.add("二");
	hs.add("三");
	lhs.add("三");
	System.out.println(hs);//无序,[三, 一, 二]
	System.out.println(lhs);//添加顺序,[一, 二, 三]
}
}
