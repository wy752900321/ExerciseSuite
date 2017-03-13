package basic.day11;

import java.util.ArrayList;

public class ArrayListAPIDemo {
	public static void main(String[] args) {
		//区别：线性表的长度（size)和线性表的容量1
		ArrayList cards = new ArrayList();
		//add是向线性表的数组中顺序追加元素
		cards.add(new Card(Card.SPADE,Card.TEN));
		cards.add(new Card(Card.SPADE,Card.JACK));
		cards.add(new Card(Card.SPADE,Card.QUEEN));
		cards.add(new Card(Card.SPADE,Card.KING));
		cards.add(new Card(Card.SPADE,Card.ACE));
		cards.add(new Card(Card.SPADE,Card.DEUCE));
		
		System.out.println(cards.size());//6,长度
		//add(index,element)在指定位置插入元素
		cards.add(0,new Card(Card.SPADE,Card.NINE));
		System.out.println(cards.toString());//需要Card类覆盖toString()方法
		Card ace = new Card(Card.SPADE,Card.ACE);
		//contains()的底层调用了每个对象的equals方法
		System.out.println(cards.contains(ace));//true
		
		ArrayList others = new ArrayList();
		others.add(new Card(Card.SPADE,Card.NINE));
		others.add(new Card(Card.SPADE,Card.TEN));
		others.add(new Card(Card.SPADE,Card.JACK));
		others.add(new Card(Card.SPADE,Card.QUEEN));
		others.add(new Card(Card.SPADE,Card.KING));

		System.out.println(cards.equals(others));//false
		System.out.println(cards.containsAll(others));//true
		others.add(new Card(Card.SPADE,Card.ACE));
		others.add(new Card(Card.SPADE,Card.DEUCE));
		
		System.out.println(cards.equals(others));//true
		
		//线性表：内容的增删改查，线性表集合的操作
		//		内容的增删改查：add()
		Card card = (Card)cards.remove(0);
		System.out.println("删除了："+card);
		card = (Card)cards.set(0, new Card(Card.SPADE,Card.THREE));
		System.out.println("换出来："+card);
		card = (Card)cards.get(0);
		System.out.println("0位置上是："+card);
		System.out.println(cards);
		//线性表的集合操作：contains()相当于集合的“属于”运算
			//containsAll()相当于集合的“包含”运算
		
//		cards.add(others);
		cards.addAll(others);
//		cards.retainAll(others);//在cards中保留others 中共有部分
//		cards.removeAll(others);//在cards中删除others包含部分
		System.out.println(cards);
		
		int index = cards.indexOf(ace);
		
	}
}
