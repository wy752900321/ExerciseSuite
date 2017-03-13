package basic.day07;

import java.util.Arrays;

/**多选也是选择题，也继承自选择题*/
public class MultiQuestion extends Question {
	char[] answers;//用户多个，多个多选答案
	//构造方法就是为属性进行初始化的
	public MultiQuestion(String title,String[] options,char[] answers){
		this.title=title;
		this.options=options;
		this.answers=answers;
	}
	/**覆盖检查方法*/
	public boolean check(char[] answers){
		if(answers==null){
			return false;
		}
		return Arrays.equals(this.answers,answers);
	}
}
