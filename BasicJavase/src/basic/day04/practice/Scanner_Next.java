package basic.day04.practice;
import java.util.Scanner;


public class Scanner_Next {

	/**
		Scanner中：
				next():不换行，下一个，空格被当作分割符，需要有效标记才能返回，
				也就是说，你必须输入东西，要是不输入就会一直提示输入
				
				nextLine():切换到下一行，是读出当前下标的一行，你可以理解为下一行，
				对他来说每行就是他的分割符，不需要标记只要有当前行就能返回
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入信息！");
		int arr = sc.nextInt();
//		String arr1=sc.next();
		String input = "1 fish 2 fish red fish blue fish";
	     Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
	     System.out.println(s.nextInt());
	     System.out.println(s.nextInt());
	     System.out.println(s.next());
	     System.out.println(s.next());
	     s.close(); 

	}

}
