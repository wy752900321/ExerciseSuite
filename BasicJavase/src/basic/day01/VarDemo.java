package basic.day01;

public class VarDemo {

	public static void main(String[] args) {
//		System.out.println(age);//编译错，变量没有声明。age cannot be resolved
		int age;//变量的声明
//		System.out.println(age);//编译错，变量没有初始化。The local variable age may not have been initialized!
		age  = 15;//变量的初始化，第一次赋值
		System.out.println(age);//输出15
		age = 16;//赋值，更改变量 的值
		System.out.println(age);//16
		int times = 10;//声明同时初始化
		System.out.println(times);
//		int age;//编译错误，变量重复声明。Duplicate local variable age!
		if(age<20){
			int score = 10;
//			System.out.println(socre);//字写错时，score cannot be resolved!
			System.out.println(score);//10
		}
//		System.out.println(score);编译错误，没有声明。score cannot be resolved!
		int score = 5;//
		System.out.println(score);//5
		
		
		System.out.println(Math.pow(2, 3));//第一个数的平方
	}

}
