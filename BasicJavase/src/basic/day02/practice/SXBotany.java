package basic.day02.practice;

public class SXBotany {

	/**
	 * 水仙花的个数是三位数，且每位的立方和就是这个三位数
	 *百分％是取下，余数。／是取上
	 */
	public static void main(String[] args) {
		SXBotany sx = new SXBotany();
		int sum;
		System.out.println("100-999之间的水仙花数为：");
		for(int i=100;i<=999;i++){
		int a = sx.getSumOfCubic(i/100);//百位上的数字
		int b =sx.getSumOfCubic((i/10)%10);//十位上的数字
		int c =sx.getSumOfCubic(i%10);//个位上的数字
		sum = a + b + c;
		if(sum==i){
			System.out.println("i="+i);
		}
		}
	}
	public int getSumOfCubic(int num){
		num=num*num*num;
		return num;
	}

}
