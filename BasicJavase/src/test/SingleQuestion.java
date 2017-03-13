package test;

public class SingleQuestion	extends Question {
	String answer;//±ê×¼´ð°¸
	public SingleQuestion(int id,String text,String[] options,String answer){
		this.id = id;
		this.text=text;
		this.options=options;
		this.answer=answer;
	}
	public boolean check(String[] ans){
		if(ans==null||ans.length!=1)
			return false;
		return this.answer.equals(ans[0]);
	}
}
