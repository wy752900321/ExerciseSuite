package basic.day04.practice;

/**
 	对于短路与和与，短路或和或区别：
 	1）.对于与操作来说如果第一个条件为假，则后面条件不管是真是假，最终结果都是假。
 	2）.对于或操作来说如果第一个条件为真，则后面条件不管是真是假，最终结果都是真。
 	3).对于与来说，要求所有的条件都判断，而如果使用短路与，第一个条件又为false，则
 		后面的条件将不再判断。
 	4）.对于或来说，要求所有的条件都判断，而如果使用短路或，第一个条件又为true，则
 		后面的条件将不再判断
 */

public class OperatorDemo01 {
	public static void main(String[] args){
		int x = 10/0;
		System.out.println("x="+x);//java.lang.ArithmeticException: / by zero
	}
}

/**对比与
 	public class OperatorDemo02 {
	public static void main(String[] args){
		if(10 != 10&10/0==0){		//非短路与
		//java.lang.ArithmeticException: / by zero
		System.out.println("条件满足");
		}
	}
}

/**对比与
 	public class OperatorDemo03 {
	public static void main(String[] args){
		if(10 != 10&&10/0==0){			//短路与
		System.out.println("条件满足");//无输出，空白
		}
	}
}
 */

/**对比或
 	public class OperatorDemo04 {
	public static void main(String[] args){
		if(10 == 10 | 10/0==0){		//非短路或
		//java.lang.ArithmeticException: / by zero
		System.out.println("条件满足");
		}
	}
}
*/

/**
 	public class OperatorDemo05 {
	public static void main(String[] args){
		if(10 == 10 || 10/0==0){		//短路或
		System.out.println("条件满足");//条件满足

		}
	}
}
*/
