package basic.day10.practice;

public class Runtime_01 {
	public static void main(String[] args) {
		for(int i=10;i>0;i--){
			System.out.println(""+(i/(i-1)));
			if(i%5 == 0)
				System.out.println();
		}
	}
}
/**
 java.lang.ArithmeticException: / by zero
*/