package basic.day13;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
	private int id ;//玩家编号
	private String name;//玩家姓名
	private ArrayList<Card> cards = new ArrayList<Card>(18);//手中的牌
	public Player(int id,String name){
		this.id = id;
		this.name = name;
	}
	//拿牌
	public void add(Card card){
		cards.add(card);
	}
	public String toString(){
		return name;
	}
}
