package basic.day04;

public class LongTimeDemo {

	public static void main(String[] args) {
		long now = System.currentTimeMillis();//从1970到现在的毫秒数
		long year = now/1000/60/60/24/365+1970;
		System.out.println(year);//今年的年份
		long max = 0x7fffffffffffffffL;
		long y = max/1000/60/60/24/366+1970;//用尽的那一年的年份。
		System.out.println(y);

	}

}
