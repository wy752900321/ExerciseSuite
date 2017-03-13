package test;

public class QuestionDemo1 {

	public static void main(String[] args) {
		SingleQuestion q1 = new SingleQuestion(1001,"＜走出软件作坊＞的作者是谁？",
						new String[]{"A.李开复","B.阿朱","C.马云","D.李彦宠"},"B");
		//子类继承了父类属性
		System.out.println(q1.id);
		System.out.println(q1.text);
		//子类自己的属性
		System.out.println(q1.answer);
		//从父类型继承方法print()
		q1.print();
		//重写父类check()方法
		System.out.println(q1.check(new String[]{"B"}));
	}

}
