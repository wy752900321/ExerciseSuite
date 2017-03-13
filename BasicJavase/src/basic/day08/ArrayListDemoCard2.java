package basic.day08;

import java.util.ArrayList;

import basic.day08.Swat.Card;

/**
 	ArrayList 的contains()方法默认调用对象（Card）的equals（）方法做比较
 * */
public class ArrayListDemoCard2 {
public static void main(String[] args) {
	ArrayList cards = new ArrayList();
	cards.add(new Card(Card.SPADE,Card.ACE));
	System.out.println(cards);//[黑桃A]
	
	//3.演示ArrayList的contain()方法
	Card ace = new Card(Card.SPADE,Card.ACE);
	System.out.println(ace);//黑桃A
	System.out.println(cards.contains(ace));//默认调用equals()
}
}
