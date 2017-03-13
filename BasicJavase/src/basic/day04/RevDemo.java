package basic.day04;

public class RevDemo {

	/**
	 * ตÝน้
	 */
	public static void main(String[] args) {
		int n = 5;
		int sum = f(n);
		System.out.println(sum);
	}
	//f(n) = n + f(n-1)and f(1) = 1
	public static int f(int n){
		if(n==1){
			return 1;
		}
		return n+f(n-1);
	}

}
