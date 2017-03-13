package basic.day02;

public class BooleanDemo {

	/**
	 * boolean
	 */
	public static void main(String[] args) {
		boolean used = true;//二手的
		boolean isMan = true;//纯爷们
		boolean m = true;//不建议使用单个字符 命名变量
		boolean started = true;
		
		if(used){
			System.out.println("打八折！");
		}
		if(isMan){
			System.out.println("纯爷们！");
		}
		System.out.println(1/10);//0
		System.out.println(9/10);//0
		System.out.println(11/10);//1
		System.out.println(2.0-1.1);//0.8999999999999999
	}

}
