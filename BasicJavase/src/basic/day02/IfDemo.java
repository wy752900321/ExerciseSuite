package basic.day02;

public class IfDemo {

	/**
	 * if语句演示
	 */
	public static void main(String[] args) {
		boolean used = false;
		if(used){
			System.out.println("二手的！");
		}else{
			System.out.println("全新货！");
		}
		//常见错误，used=true是赋值运算
		 used = false;
		 if(used=true){
			 System.out.println("二手的");
		 }
		//选择输出结果：A.编译错误 B.运行错误 C.无 D.二手的！
	}
}
