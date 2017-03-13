package test;

public class CardDemo {
	public static void main(String[] args) {
		//创建扑克：方块3
		Card card = new Card(Card.DIAMOND,Card.THREE);
		//黑桃A
		Card c = new Card(3,11);
		//黑桃A
		Card ace  = new Card(Card.SPADE,Card.ACE);
		ace.setRank(1000);//如果有人作弊，会出异常
	}
}
