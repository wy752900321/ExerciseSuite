package basic.day11;

public class LinkdeDemo {
public static void main(String[] args) {
	Node head = new Node("忐忑");
	head.next = new Node("朋友");
	head.next.next= new Node("月亮之上");
	head.next.next.next= new Node("学习雷锋好榜样");
	System.out.println(head);
}
}
class Node{//节点，代表链表的节点类型
	Object data;
	Node next;
	public Node(Object obj){
		data = obj;
	}
	public String toString(){//不要纠结这个方法，测试方法
		return next == null ?data.toString() : data+","+next;
	}
}