package basic.day13;

import java.util.ArrayList;
import java.util.Random;

public class ArrayListDemo1 {
	public static void main(String[] args) {
		ArrayList als = new ArrayList();
		als.add(new Card(Card.DIAMOND,Card.THREE));
		als.add(new Card(Card.DIAMOND,Card.FOUR));
		als.add(new Card(Card.DIAMOND,Card.FIVE));
		als.add(new Card(Card.DIAMOND,Card.SIX));
		
		//1.删除remove()方法演示
//		Card ace = new Card(Card.DIAMOND,Card.SIX);
		//1.1删除对象
//		als.remove(ace);
		//1.2按序号删除 
//		als.remove(2);
		//模拟打牌
		Random r = new Random();//随机抽取一张
		Card c1 = (Card)als.remove(r.nextInt(als.size()));
		System.out.println(c1);//被删除的元素
		System.out.println(als);
		//3.修改set()方法演示：
		//修改ArrayList中的第0个元素为“大王”
		Card joker = new Card(Card.JOKER,Card.COLOR);
		Card first = (Card)als.set(0, joker);
		System.out.println(als);
		
	}
}
