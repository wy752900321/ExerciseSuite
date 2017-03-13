package test;

public class QuestionDemo2 {
	public static void main(String[] args) {
		MultiChoiceQuestion q2 = new MultiChoiceQuestion(1002,"这些电影你看过哪部？",
				new String[]{"A. 阿甘正传","B.勇敢的心","c.<阿凡达＞","D.<放牛班的春天＞"},new String[]{"A","B"});
		q2.print();
		System.out.println(q2.check(new String[]{"A","B"}));
	}
}
