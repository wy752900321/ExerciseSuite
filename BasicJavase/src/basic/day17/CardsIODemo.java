package basic.day17;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import basic.day16.IOUtils;

/*
 * 8 浅层复制与深层复制
 *	1) Java的默认复制规则是浅层复制, 性能好, 隔离性差浅层复制现象, 只复制第一层对象
 *	2) 利用序列化实现深层复制
 *DataInputStream:数据输入流允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型。
 *					应用程序可以使用数据输出流写入稍后由数据输入流读取的数据。 
 *DataOutputStream:数据输出流允许应用程序以适当方式将基本 Java 数据类型写入输出流中。
 *					然后，应用程序可以使用数据输入流将数据读入。
 *		writeInt(int v) 将一个 int 值以 4-byte 值形式写入基础输出流中，先写入高字节。
 */
public class CardsIODemo {
	public static void main(String[] args) throws IOException {
		List<Card> cards = new ArrayList<Card>();
		for (int rank = Card.THREE; rank <= Card.DEUCE; rank++) {
			cards.add(new Card(Card.DIAMOND, rank));
			cards.add(new Card(Card.CLUB, rank));
			cards.add(new Card(Card.SPADE, rank));
			cards.add(new Card(Card.HEART, rank));
		}
		cards.add(new Card(Card.JOKER, Card.BLACK));
		cards.add(new Card(Card.JOKER, Card.COLOR));
		Collections.shuffle(cards);
		String file = "cards.dat";
		OutputStream out = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(out);
		for (Card card : cards) {// card代表cards中的每一个扑克牌对象
			dos.writeInt(card.getSuit());
			dos.writeInt(card.getRank());
		}
		dos.close();
		IOUtils.print(file);
		// 将文件cards.dat 读取为Card的集合others
		DataInputStream dis = new DataInputStream(new BufferedInputStream(// 增加输入缓冲流,自动处理缓冲
				new FileInputStream(file)));
		List<Card> others = new ArrayList<Card>();
		for (;;) {// while(true)
			try {
				int suit = dis.readInt();// 先读取花色
				int rank = dis.readInt();// 再读取点数, 顺序与写入一致
				others.add(new Card(suit, rank));
			} catch (EOFException e) {// 当readInt()方法遇到文件末尾时候
				System.out.println("读取结束!");
				break;// 到文件尾部就结束while循环了
			}
		}
		System.out.println(others);
		System.out.println(others.equals(cards));// 两个集合内容一样
		System.out.println("others是cards的深层复制的副本！");
		System.out.println(others == cards);// false
		System.out.println(others.get(0) == cards.get(0));// false
		// System.out.println(others.get(0).equals(cards.get(0)));
		// 浅层复制
		List<Card> cards2 = new ArrayList<Card>(cards);
		System.out.println("cards2是cards浅层复制的副本！");
		System.out.println(cards2 == cards);// false
		System.out.println(cards2.get(0) == cards.get(0));// true
	}
}
