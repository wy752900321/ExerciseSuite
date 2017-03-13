package basic.day13;

import java.util.ArrayList;

/**
 	线性表List 表示有先后次序的对象集合，比如：歌曲列表。
		1)   ArrayList = Object[] + 线性表操作(增删改查)
		2)   StringBuilder = char[] + 操作(增删改查)
	将 ArrayList 和 StringBuilder 对比，案例如下：
 */
public class ArrayListDemo {
	public static void main(String[] args) {
		StringBuilder sbl = new StringBuilder();
		sbl.append("达");
		sbl.append("内");
		sbl.insert(0, "中");
		sbl.insert(1, "国");
		System.out.println(sbl);
		System.out.println(sbl.charAt(2));//检索第几个位置是什么 
		
		ArrayList al = new ArrayList();
		al.add("达");
		al.add("内");
		al.add(0, "中");
		al.add(1, "国");
		al.set(2, "北");
		al.set(3, "京");
		System.out.println(al);
		System.out.println(al.indexOf("北"));//在哪个位置上
		System.out.println(al.get(2));//得到这个位置上的字符
		
//ArrayList和StringBuilder相比，操作基本相同，但是 ArrayList 除了可以添加 String，还可以添加其它对象，如下图所示
		ArrayList cards = new ArrayList();
		cards.add(0, new Card(Card.SPADE,Card.KING));
		cards.add(0, new Card(Card.DIAMOND,Card.THREE));
		cards.add(0, new Card(Card.SPADE,Card.FOUR));
		cards.add(0, new Card(Card.DIAMOND,Card.KING));
		System.out.println(cards);
		
		//ArrayList 的 contains()方法默认调用对象（Card）的 equals()方法做比较，如下图所示：
		//  如果 Card.java 丌覆盖 equals()方法，则结果为 false
		Card ace = new Card(Card.DIAMOND,Card.THREE);
		System.out.println(cards.contains(ace));//true
		System.out.println(cards);

	}
}
