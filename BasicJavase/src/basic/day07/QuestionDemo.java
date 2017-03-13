package basic.day07;

import java.util.Scanner;

public class QuestionDemo {

	/**
	 * 继承关系的使用，与测试
	 */
	public static void main(String[] args) {
		//paper 表示试卷，表达：试卷包含多个选择题
		//对象数组，元素自动初始化为null，元素是类型为Question
		//元素是引用变量,表示试卷上有两个考题的空(null)位置
		Question[] paper = {null,null};//new Question[2];
		//静态数组只能用在，声明同时初始化时，如下
		paper[0] = new SingleQuestion("java特点是",new String[]
		          {"A面向过程","B多线程","C 与C语言一样","D 是咖啡品种"},'B');
		paper[1] = new MultiQuestion("java基本类型包括",new String[]
		         {"A String","B int","C long","D Boolean"},new char[]{'B','C'});//AD是包装类，首字母大写
		Scanner console = new Scanner(System.in);
		for(int i=0;i<paper.length;i++){
			Question question = paper[i];
			question.print();//print(question)
			System.out.println("请选择：");
			//console,nextLine()从控制台读取下一行字符串
			String ans = console.nextLine();//'A','ABC'.
			char[] answers = ans.toCharArray();//"ABC"->［'A','B','C'］
			//方法是动态绑定到到对象的方法上！编译期间按照类型检查！运行期运行按具体对象的方法
			if(question.check(answers)){
				System.out.println("行呀！");
			}else{
				System.out.println("还需努力！");
			}
		}
	}
}
