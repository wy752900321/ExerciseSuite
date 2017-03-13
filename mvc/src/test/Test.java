package test;

import exception.HeightLimitException;
import service.BMIService;

public class Test {
	public static void main(String[] args) {
		BMIService service = new BMIService()	;
		try {
			String rs = service.bmi(2.7, 180, "m");
			System.out.println(rs);
		} catch (Exception e) {
			// 记录日志
			e.printStackTrace();
			//依据异常类型，进行处理
			//区分异常，对于系统异常提示用户。如果是应用异常，提示用户正确输入。
			if(e instanceof HeightLimitException){
				System.out.println("身高范围必须大于0并且小于2.5");
			}
		}
	}
}
