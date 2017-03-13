package basic.day10;
import java.util.Scanner;
import java.util.Arrays;
public class AnswerCheckDemo {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String reg = "^\\s*([A-Da-d](\\s+|,\\s*)?){1,4}\\s*$";
		String str;
		while(true){
			System.out.println("输入选择答案（A－D）：");
			str = console.nextLine();
			if(str.matches(reg)){
				break;
			}
			System.out.println("错了！再试试呗.");
		}
		reg = "\\s+";//切分规则
		String[] ans = str.split(reg);//切分字符串为数组
		Arrays.sort(ans);//排序答案
		System.out.println(Arrays.toString(ans));
		
	}

}
