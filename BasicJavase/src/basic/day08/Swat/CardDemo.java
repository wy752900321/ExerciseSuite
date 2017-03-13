package basic.day08.Swat;
import java.util.Arrays;
import java.util.Random;

public class CardDemo {

	public static void main(String[] args) {
		
		//1.构建一副扑克牌，54张
		Card[] cards = new Card[54];
		int i = 0;
		for(int rank=Card.THREE;rank<=Card.DEUCE;rank++){
			cards[i++]=new Card(Card.DIAMOND,rank);//13张
			cards[i++]=new Card(Card.CLUB,rank);//13张
			cards[i++]=new Card(Card.HEART,rank);
			cards[i++]=new Card(Card.SPADE,rank);//13张
		}
		cards[i++] = new Card(Card.JOKER,Card.BLACK);//小王
		cards[i++] = new Card(Card.JOKER,Card.COLOR);//大王
		
		//2.洗牌（打乱算法）
		Random r = new Random(); 
		for(i=cards.length-1;i>=1;i--){
			int j = r.nextInt(i);//i表示最后一张的位置
			Card t = cards[i];
			cards[i] = cards[j];
			cards[j]=t;
		}
		System.out.println(Arrays.toString(cards));
		
		//3.发牌
		Player[] players = {new Player(1,"春哥"),new Player(2,"曾哥"),new Player(3,"纯爷们")};
		int j = 0;
		for(i=0;i<cards.length;i++){
			Card c = cards[i];
			players[j++%players.length].add(c);
		}
		System.out.println(players[0]);
		System.out.println(players[1]);
		System.out.println(players[2]);
		
	}

}
