package basic.day08;
import java.util.LinkedList;

import basic.day08.Swat.Card;
/**
 	LinkedList和ArrayList使用方法相同，底层实现不相同
 */
public class ArrayListDemoCard4 {
	public static void main(String[] args) {
		LinkedList cards = new LinkedList();
		//1.增加元素
		cards.add(new Card(Card.SPADE,Card.TEN));
		cards.add(new Card(Card.SPADE,Card.JACK));
		cards.add(new Card(Card.SPADE,Card.QUEEN));
		System.out.println(cards);//[黑桃10, 黑桃J, 黑桃Q]
		//2.删除元素
		cards.remove(0);
		cards.remove(new Card(Card.SPADE,Card.QUEEN));
		System.out.println(cards);//[黑桃J]
		//3.修改元素
		Card joker = new Card(Card.JOKER,Card.COLOR);
		cards.set(0, joker);
		System.out.println(cards);//[大王]]
		//4. 查询元素
		System.out.println(cards.indexOf(joker));//-1

	}
}
