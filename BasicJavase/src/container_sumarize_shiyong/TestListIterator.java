package container_sumarize_shiyong;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//ListIterator迭代器
public class TestListIterator {
public static void main(String[] args) {
	List l = new ArrayList();
	l.add("孙悟空");
	l.add("猪八戒");
	ListIterator li = l.listIterator();
	while(li.hasNext()){
		System.out.println(li.next());
		li.add("－－－－－－－－");
	}
	System.out.println("开始反向迭代");
	System.out.println(li.previous());//测试迭代器指针指向的位置
	while(li.hasPrevious()){
		System.out.println(li.previous());
	}
}
}
