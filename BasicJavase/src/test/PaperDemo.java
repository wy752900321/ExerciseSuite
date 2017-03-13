package test;

import java.util.Scanner;

public class PaperDemo {
	public static void main(String[] args) {
		//构建考卷paper，考卷paper是Question的集合
		Question[] paper = new Question[2];
		paper[0]=new SingleQuestion(1001,"走进软件作坊的作者是谁？",new String[]{"A.李开复","B.阿朱","C.马云","D.李彦宏"},"A");
		paper[1]=new MultiChoiceQuestion(1002,"寻找科技的主持是",new String[]{"A.李开复","B.阿朱","C.马云","D.李彦宏"},new String[]{"A","B"});
		Scanner s = new Scanner(System.in);
		for(int i=0;i<paper.length;i++){
			Question q = paper[i];
			q.print();
			System.out.print("请选择：");
			String[] ans = s.nextLine().split(",");
			if(q.check(ans)){
				System.out.println("行啊");
			}else{
				System.out.println("继续努力呀！");
			}
		}
		
	}
}
