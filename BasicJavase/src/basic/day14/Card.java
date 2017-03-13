package basic.day14;

/**扑克牌*/
public class Card {

	public static final int DIAMOND = 0;//diamond方块
	public static final int CLUB = 1;//club梅花
	public static final int HEART = 2;//heart,红心
	public static final int SPADE =3;//spade黑桃
	public static final int JOKER = 4;//王
	
	private int suit;//花色，0代表 方块，1代表梅花
	private int rank;//点数，0代表3 1代表4
	
	public final static int THREE = 0;//three
	public final static int FOUR = 1;
	public final static int FIVE = 2;
	public final static int SIX = 3;
	public final static int SEVEN = 4;
	public final static int EIGHT = 5;
	public final static int NINE = 6;
	public final static int TEN = 7;
	public final static int JACK = 8;//J,jack
	public final static int QUEEN = 9;//Q,queen
	public final static int KING = 10;//K，king
	public final static int ACE = 11;//A，ace点，高手
	public final static int DEUCE = 12;//2,deuce两点
	public final static int BLACK = 13;//black,小王
	public final static int COLOR = 14;//color,大王
	
	public Card(){
	}
	public Card(int suit,int rank){
		this.suit = suit;
		this.rank = rank;
	}

	public static int getDIAMOND() {
		return DIAMOND;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	private final static String[] 
	     SUIT_NAMES = {"方块","梅花","红桃","黑桃",""};
	private final static String[]
	     RANK_NAMES = {"3","4","5","6","7","8","9","10","J","Q","K","A","2","小王","大王"};
	
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(this==obj)
			return false;
		if(obj instanceof Card){
			Card other = (Card)obj;
			return this.rank==other.rank && this.suit ==other.suit;
		}
		return false;
	}
	public int hashCode(){
		//suit = 2  00000000 00000000 00000000 00000010
		//rank = 3	00000000 00000000 00000000 00000011
//		return (this.suit<<16)+this.rank;//同下，用移位的方法也可以,二进制移动，都是拼数
		return this.suit*100 + this.rank;//乘100，是为了不想值相等，十进制移动，都是拼数
	}
	
	public String toString(){
		/*
		 	将花色suit和点数rank作为数组
		 	SUIT_NAMES和RANK＿NAMES的下标
		 	输出时为相应的扑克牌，如：梅花A
		 */
		return SUIT_NAMES[suit]+RANK_NAMES[rank];
	}
}
