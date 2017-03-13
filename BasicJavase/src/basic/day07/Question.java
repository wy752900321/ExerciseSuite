package basic.day07;

/**选择题，考题是继承的父类型，要派生出子类型：单选题和多选题
 *	A. 继承体现了自然逻辑系统中的分类关系 
 *	B.父类型声明所有子类的公共特征（属性）和形为（公共方法）
 *	C.子类可以继承父类型的可以继承的属性和方法。
 *	D.继承可以实现代码的复用（重用),子类可以不用再定义了
 *	E.子类可以声明特有的属性和方法，这种现象叫特化（具体化，特殊化）
 *	F.子类可以覆盖（重写）父类型的功能，实现多态行为
 *		如：具体鸟（企鹅）可能修改了父类型（鸟类）飞翔的行为（多态）
 */
public class Question {
	String title;//题干
	String[] options;//选项
	public void print(/*Question this*/){//打印题
		System.out.println(title);//this.title
		for(int i=0;i<options.length;i++){//this.options.length
			String option = options[i];
			System.out.println("\t"+option);
		}
		System.out.println();
	}
	public boolean check(char[] answers){//检查用户答案
		return false;
	}
}
