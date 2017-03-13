package basic.day07.practice;

public class PI {

	/**
	 	11、计算圆周率
  				PI＝4－4/3+4/5-4/7.......
  				打印出第一个大于 3.1415小于 3.1416的值

	 */
	public static void main(String[] args) {
		double pi = 0;//定义初始值
		double fenZi =4;//分子为4
		double fenMu=1;//分母为1,第一个4，可看作分母为1的分式，以后的分母每次递增2
		for(int i=0;i<1000000000;i++){//运行老久，减少循环次数会快很多，只是精确度小些
			pi += (fenZi/fenMu);
			fenZi *= -1.0;//每次分子的变化是+4,-4,+4,-4....
			fenMu += 2.0;	//分母的变化的1，3，5，7，....每项递加2
		}
		long a = System.currentTimeMillis();//测试运行时间
		System.out.println(pi);
		long b =System.currentTimeMillis();//测试程序运行时间
		System.out.println(b-a);
	}

}
