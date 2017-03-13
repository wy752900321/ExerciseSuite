package interview;

public class CharDemo {

	/**
	 * 取小数点之前的数
	 */
	public static void main(String[] args) {
		/**
		String temp = String.valueOf("数字或字符串");//把整数或小数变成String类型的temp
		int index = temp.indexOf("   .   ");//从这个数开始，看第几位能找到小数点，第几位
		temp = temp.substring(0,"(index)+数");//然后把从0位到第n位的数赋值给temp
		 */
		String temp = String.valueOf("15145dfaf.15fvgdsag");//把整数或小数变成String类型的temp
		int index = temp.indexOf(".");//从这个数开始，看第几位能找到小数点，第几位
		temp = temp.substring(0,index);//然后把从0位到第n位的数赋值给temp
		System.out.println(temp);

	}

}
