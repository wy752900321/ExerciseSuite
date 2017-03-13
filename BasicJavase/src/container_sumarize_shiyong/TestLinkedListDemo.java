package container_sumarize_shiyong;

import java.util.LinkedList;

/**Queue接口
 	LinkedList实现类
 */
public class TestLinkedListDemo {
public static void main(String[] args) {
	LinkedList ll = new LinkedList();
	//将新元素加入队列尾部
	ll.offer("java");// 将指定元素添加到此列表的末尾（最后一个元素）
	//将一个字符串入栈
	ll.push("C++");// 将元素推入此列表所表示的堆栈。
	System.out.println(ll);//[C++, java]
	
	//将一个字符串添加到队列头部
	ll.offerFirst("VB");// 在此列表的开头插入指定的元素。
	System.out.println(ll);//[VB, C++, java]
	//访问并不删除第一个元素
//	获取但不移除此列表的第一个元素；如果此列表为空，则返回 null。
	System.out.println(ll.peekFirst());//VB
	//第一个元素出栈
	System.out.println(ll.pop());//VB,从此列表所表示的堆栈处弹出一个元素
	System.out.println(ll);//[C++, java]
}
}
