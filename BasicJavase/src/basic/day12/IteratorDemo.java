package basic.day12;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorDemo {
public static void main(String[] args) {
	Set<String> eggs = new HashSet<String>();
	eggs.add("¼¦µ°");
	eggs.add("Ñ¼µ°");
	eggs.add("Æ¤µ°");
	eggs.add("¶ìµ°");
	eggs.add("»µµ°");
	int n = 0;
	Iterator<String> ite = eggs.iterator();//¶Ôset¼¯ºÏ½øÐÐµü´ú
	while(ite.hasNext()){
		String egg = ite.next();
		System.out.println(egg);
		n++;
		if(egg.equals("»µµ°")){
			ite.remove();
			n--;
		}
	}
	System.out.println(n);
	System.out.println(eggs);
}
}
