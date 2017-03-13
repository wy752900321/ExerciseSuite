package basic.day06.practice;

public class DoWhileCycle_01 {
	public static void main(String[] args) {
		
		System.out.println(0%2);//0
		System.out.println(1%2);//1
		System.out.println(1%5);//1
		System.out.println(4%5);//4
		System.out.println(4%4);//0
		System.out.println(4/4);//1
		System.out.println(1/5);//0
		System.out.println(1/2);//0
		
		int nums = 0;//用于记录奇数的个数
		int i = 1;
		System.out.println("1~100的奇数如下：");
		do{
			if(i%2==1){
				nums++;
				System.out.println(i+"");
			if(nums%5==0)
				System.out.println();
		}
		i++;
	}while(i<=100);
	}
}