package basic.day06.practice;
public class DoWhileCycle_02 {
	public static void main(String[] args) {
		int max = 0;		// 表示最大值
		int i = 0;			// 循环的次数
		int n1 = 0;		// 随机数
		System.out.println("随机生成的10个随机数分别为：");
		do {
			n1 = (int) (Math.random() * 100);	// 通过Math类random的产生0～99之间的随机正整数
			if (i == 0) {						// 如果是第一次循环
				max = n1;					// 则最大值为当前随机数
		// 否则，则将当前随机数与max的变量值进行比较，将最大值存放在max变量中
			} else if (n1 > max) {
				max = n1;
			}
			i++;							// 循环次数自动加1
			System.out.print(n1 + "  ");
		} while (i < 10);
		System.out.println("\n\n值最大的数字为：" + max);
	}
}

