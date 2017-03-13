package basic.day08.Swat;

import java.util.Arrays;


public class Player {
	private int id ;//玩家编号
	private String name;//玩家姓名
	private Card[] cards = {};//手中的牌
	public Player(int id,String name){
		this.id = id;
		this.name = name;
	}
	//拿牌
	public void add(Card card){
		cards = Arrays.copyOf(cards, cards.length+1);
		cards[cards.length-1] = card;
	}
	public String toString(){
		return id+","+name+Arrays.toString(cards);
	}
}
