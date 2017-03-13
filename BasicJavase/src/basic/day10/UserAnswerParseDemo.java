package basic.day10;

import java.util.Scanner;
import java.util.Arrays;

public class UserAnswerParseDemo {

	public static void main(String[] args) {
		//"c,A b"->[A,B,C]
		
		String rule = "^\\s[a-dA-D]((,\\s*|\\s+)[a-dA-D]){0,3}\\s*$";
		Scanner in =new Scanner(System.in);
		String ans;
		while(true){
			System.out.println("输入选择答案（a-d）:");
			ans = in.nextLine();
			if(ans.matches(rule)){
				break;
			}
			System.out.println("错了！坑跌！");
		}
		String[] answers = ans.trim().toUpperCase().split("(,\\s*|\\s+)");
		Arrays.sort(answers);
		System.out.println(Arrays.toString(answers));
	}

}
