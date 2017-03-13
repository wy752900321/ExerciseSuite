package basic.day07.practice;
import java.util.Scanner;
public class Multinomial {

	/**
	  	求  a+aa+aaa+.......+aaaaaaaaa=?
      	其中a为1至9之中的一个数，项数也要可以指定。
	 */
	public static void main(String[] args) {
		int a;//定义输入的a
		int howMany;//定义最后的一项有多少个数字
		Scanner scanner = new Scanner(System.in);
			System.out.println("请输入一个1～9的a值");
		a = scanner.nextInt();
			System.out.println("请问要相加多少项？");
		howMany=scanner.nextInt();
		int sum=0;
		int a1=a;//用来保存a的初始值
		for(int i=1;i<=howMany;i++){
			sum+=a;
			a=10*a+a1;//这表示a的下一项
	//每次a的下一项都等于前一项＊10，再加上刚输入时的a;注意，这时的a已经变化了
		}
		System.out.println("sum="+sum);
	}

}
