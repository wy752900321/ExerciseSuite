package basic.day02;

public class LogicDemo2 {

	/**
	 * 短路逻辑判断
	 */
	public static void main(String[] args) {
		// 短路的与运算(&&),允许60岁以上老太太进来＝＞是女的并且＞＝60岁
		int age = 68;
		char sex = '男';
		/**
		 * 当sex=='女'，返回false时候，不再运算age>=60直接认为结果是false
		(sex=='女' && age>=60)
		 */
		if(sex=='女' && age>=60){
			System.out.println("欢迎光临！");
		}
		System.out.println("age="+age);//68,说明age++>=60没有计算
		//证明了&&是短路的逻辑运算
		//非短路的与运算（＆）
		age = 68; 
		sex ='男';
		if(sex=='女' & age++>=60){
			System.out.println("欢迎光临！");
		}
		System.out.println("age="+age);//69
		
		//短路的或运算(||):允许女的或者60岁以上老头进来
//		没有执行age++>=60
		age = 28;
		sex ='女';
		if(sex=='女' || age++>=60){
			System.out.println("欢迎光临！");//欢迎光临！
		}
		System.out.println("age="+age);//age=28
		
		//只要一个满足条件的，就进入循环。执行了age++>=60
		age = 78;
		sex ='女';
		if(sex=='男' | age++>=60){
			System.out.println("欢迎光临！");//欢迎光临！
		}
		System.out.println("age="+age);//age=79
	}

}
