package basic.day18.IO;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class TestCard {
	public static void main(String[] args) throws Exception{
		String file = "card.dat";
		ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(file)));
		Object obj = new Foo2();
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Card.SPADE,Card.ACE));
		out.writeObject(obj);
		out.writeObject(cards);
		out.close();
		IOUtils.print(file);
	}
}
class Foo2 implements Serializable {
	int i = 5;

	String name = "tom";
}