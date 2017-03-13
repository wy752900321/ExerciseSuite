package basic.day10;
import java.util.Arrays;
public class StringRegexDemo {

	public static void main(String[] args) {
		String name = "jerry56";
		
		String rule = "^\\w{6,10}$";
		boolean pass = name.matches(rule);//匹配
		System.out.println(pass);//true
		
		String str = "Tom|Jerry|Andy|John";
		String[] names = str.split("\\|");//（）里是切子字符的依据
		System.out.println(Arrays.toString(names));//[Tom, Jerry, Andy, John]
		
		//str.replaceAll("\\|", ",");//有问题！得到的值没接收
		str = str.replaceAll("\\|", ",");//匹配｜线
		System.out.println(str);//Tom,Jerry,Andy,John
		
		//有错，没接收，新字符
		name = " 	Tom 			t	";
		name.trim();
		System.out.println(name);// 	Tom 			t
		
		//有错，没接收
		name = " 	Tom 			t	";
		name.trim().toLowerCase();
		System.out.println(name);// 	Tom 			t
		
		//字符串只要有变化，返回的都是新字符串
		name = " 	Tom 			t	";
		name=name.trim();
		System.out.println(name);//Tom
	}

}
