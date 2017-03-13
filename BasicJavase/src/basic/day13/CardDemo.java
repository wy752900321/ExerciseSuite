package basic.day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class CardDemo {
public static void main(String[] args) {
	List<Card> cards = new LinkedList<Card>();
	for(int rank=Card.THREE;rank<=Card.DEUCE;rank++){
		cards.add(new Card(Card.SPADE,rank));
		cards.add(new Card(Card.DIAMOND,rank));
		cards.add(new Card(Card.HEART,rank));
		cards.add(new Card(Card.CLUB,rank));
	}
	cards.add(new Card(Card.JOKER,Card.BLACK));
	cards.add(new Card(Card.JOKER,Card.COLOR));
	//Collections是集合的工具栏，类似于Arrays
	//shuffle打乱，洗牌,专业洗牌算法
	Collections.shuffle(cards);
	List<Player> players = new ArrayList<Player>();
	players.add(new Player(0,"佟汀玉"));
	players.add(new Player(1,"白展堂"));
	players.add(new Player(2,"莫小贝"));
	
	int i = 0;
	Iterator<Card> ite = cards.iterator();
	while(ite.hasNext()){
		Card card = ite.next();
//		players.get(i++%players.size()).add(card);
		Player someone = players.get(i++%players.size());
		someone.add(card);
		ite.remove();
		if(cards.size()==3){
			break;
		}
	}
	System.out.println(players.get(0));
	System.out.println(players.get(1));
	System.out.println(players.get(2));
	System.out.println(cards);
}
}
