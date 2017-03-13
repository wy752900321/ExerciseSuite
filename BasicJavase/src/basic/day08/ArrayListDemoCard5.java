package basic.day08;
import java.util.ArrayList;

import basic.day08.Swat.Card;
public class ArrayListDemoCard5 {
	public static void main(String[] args) {
		ArrayList cards = new ArrayList();//变长数组
		cards.add(new Card(Card.SPADE,Card.TEN));
		cards.add(new Card(Card.SPADE,Card.JACK));
		cards.add(new Card(Card.SPADE,Card.QUEEN));
		cards.add(new Card(Card.SPADE,Card.KING));
		cards.add(new Card(Card.SPADE,Card.ACE));
		System.out.println(cards);//[黑桃10, 黑桃J, 黑桃Q, 黑桃K, 黑桃A]
		
		ArrayList others  = new ArrayList();
		others.add(new Card(Card.CLUB,Card.DEUCE));
		others.add(new Card(Card.CLUB,Card.ACE));
		System.out.println(others);//[梅花2, 梅花A]
		
		//1.将cards和others合并（和）
		cards.addAll(others);
		System.out.println(cards);//[黑桃10, 黑桃J, 黑桃Q, 黑桃K, 黑桃A, 梅花2, 梅花A]
		//2.将cards中包含others的元素删除（差）
//		cards.removeAll(others);
		System.out.println(cards);//[黑桃10, 黑桃J, 黑桃Q, 黑桃K, 黑桃A, 梅花2, 梅花A]
		//3.将cards中包含others的元素保留（交集）
		cards.retainAll(others);
		System.out.println(cards);//[]
		//4 .判断cards是否为空集（空）
		System.out.println(cards.isEmpty());//true
		//5. "空集“和“空（null)“是两码事
		cards = null;
		System.out.println(cards);//null 
	}	
}
