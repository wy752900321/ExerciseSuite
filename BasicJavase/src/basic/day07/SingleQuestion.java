package basic.day07;

/**
 * 单选题，单选题扩展于选择题，
*/

public class SingleQuestion extends Question {
	char answer;//单选的标准答案
	public SingleQuestion(String title,String[] options,char answer){
		this.title = title;//this.title继承于父类型Question
		this.options=options;
		this.answer=answer;//子类声明的特殊属性
	}
	/**覆盖（重写）检查题的方法，修改（实现）具体的检查逻辑
	 *子类的方法签名与父类中的方法中的方法签名一样。 
	 */
	public boolean check(char[] answers){
		if(answers==null||answers.length!=1){
			return false;
		}
		return this.answer==answers[0];
	}
}
