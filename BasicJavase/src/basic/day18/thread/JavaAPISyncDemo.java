package basic.day18.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 		StringBuilder线程不安全，是不同步的
		StringBuffer 线程安全，是同步的
		ArrayList线程不安全
		Vector线程安全
		Vector和Hashtable是同步的
		ArrayList和HashMap不是同步的
 */
public class JavaAPISyncDemo {
	public static void main(String[] args) {
		StringBuilder s;
		StringBuffer ss;
		
		List<String> list = new ArrayList<String>();
		list.add("Tom");
		
		list = Collections.synchronizedList(list);
	}
}
class Tester{
//	StringBuffer str = new StringBuffer();
	public void test(){
		StringBuilder s = new StringBuilder();
	}
}