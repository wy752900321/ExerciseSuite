package basic.day02.practice;

/**
 * 编写程序求 1+3+5+7+……+99 的和值。
 */

public class Odd {


	public static void main(String[] args) {
		int sum = 0;
		for(int j=1;j<100;j+=2){
			sum+=j;
		}
		System.out.println(sum);
	}
	//方法2
//    public static void main(String[] args){
//        int number = 1;  //初始值1，以后再+2递增上去
//        int sum = 0;
//        for ( ; number <100; number+=2 ){ sum += number; }
//        System.out.println("1+3+5+7+……+99= " +sum);
//    }
}
