package basic.day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

/**
 	comparable与comparator
 	排序比较大小
 */
public class SortDemo {
public static void main(String[] args) {
	//排序的前提是：被排的元素是可以比较大小的！
	List<String> names = new ArrayList<String>();
	names.add("Tom");
	names.add("Andy");
	names.add("Nimo");
	names.add("Jerry");
	names.add("John");
	names.add("Jack");
	System.out.println(names);//[Tom, Andy, Nimo, Jerry, John, Jack]
	Collections.sort(names);
	System.out.println("排序："+names);//排序：[Andy, Jack, Jerry, John, Nimo, Tom]
	//字符串是可以比较大小的，所以才能排序
	String s1 = "Tom";
	String s2 = "Jerry";
	//compareTo()是字符串上声明的方法，比较当前字符串和另外一个字符串
	//字符串大小的方法，返回＞0的数表示当前字符串大约另外一个字符串，＝0表示相等，＜0表示比另外的字符小
	//compareTo()底层一般使用减法（－）实现
	System.out.println(s1.compareTo(s2));//10
	System.out.println(s2.compareTo(s1));//-10
	System.out.println(s2.compareTo(s2));//0
	//java.lang.Comparable接口中声明了compareTo()方法
	//Comparable：可以比较的
	//String 实现了接口Comparable:表达了：String是可以比较大小的
	//String实现了Comparable中的方法compareTo()
	//java中将实现Comparable接口的类，称为：可以自然排序的。
	//compareTo()方法的实现与equals()方法是一致的
	
	//自定义排序：java.util.Comparator 接口用来规定自定义的排序
	//Comparator:比较者，比较工具器，比较器
	//Comparator代表临时的自定义排序规则：如：按照重量排序等
	ByLength byLength = new ByLength();
	Collections.sort(names,byLength);//按照长度自定义排序
	System.out.println("ByLength:"+names);//ByLength:[Tom, Nimo, John, Jack, Andy, Jerry]
	
}
}
/**自定义比较规则：按照长度比较*/
class ByLength implements Comparator<String>{
	//回调方法， 是被其他API调用的方法
	public int compare(String o1,String o2){
		System.out.println("o1:"+",o2:"+o2);
		int val= o1.length()-o2.length();
		if(val==0){//如果长度一样，按字符串大小，反过来排
			return -o1.compareTo(o2);
		}
		return val;
	}
	

	
}
