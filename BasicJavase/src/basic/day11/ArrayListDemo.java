package basic.day11;

import java.util.ArrayList;

public class ArrayListDemo {
public static void main(String[] args) {
	StringBuilder buf = new StringBuilder();//内为char[]字符
	buf.append('达');
	buf.append('内');
	buf.insert(0, '北');
	buf.insert(2,'京');
	System.out.println(buf.toString());//北达京内
	ArrayList list = new ArrayList();//object，字符串对象
	list.add("达");
	list.add("内");
	list.add(0,"北");
	list.add(1,'京');
	System.out.println(list);//[北, 京, 达, 内]
}
}
