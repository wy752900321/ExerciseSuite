package basic.day08;

import java.util.ArrayList;
import java.util.Random;

import basic.day08.Swat.Card;
/**
 	演示ArrayList的删改查
 */
public class ArrayListDemoCard3 {
public static void main(String[] args) {
	ArrayList cards = new ArrayList();//变长数组
	cards.add(new Card(Card.SPADE,Card.TEN));
	cards.add(new Card(Card.SPADE,Card.JACK));
	cards.add(new Card(Card.SPADE,Card.QUEEN));
	cards.add(new Card(Card.SPADE,Card.KING));
	cards.add(new Card(Card.SPADE,Card.ACE));
	System.out.println(cards);//[黑桃10, 黑桃J, 黑桃Q, 黑桃K, 黑桃A]
	
	//1.	删除remove()方法演示
	Card ace  = new Card(Card.SPADE,Card.ACE);
	//1.1按对象删除
	cards.remove(ace);
	System.out.println(cards);
	//1.2 按序号删除
	cards.remove(0);
	
	//2. 模拟“打牌
	Random r = new Random();//随机抽取一张
	Card c1 = (Card)cards.remove(r.nextInt(cards.size()));
	System.out.println(cards);
	
	//3. 修改set()方法演示
	//修改ArrayList中的第0个元素为“大王”
	Card joker = new Card(Card.JOKER,Card.COLOR);
	Card first = (Card)cards.set(0, joker);
	
	//4. 查询indexOf()方法演示：查询ArrayList中的元素
	int i = cards.indexOf(joker);//默认调用equals()比较
	System.out.println(cards);//
}
}
