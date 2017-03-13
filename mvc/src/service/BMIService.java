package service;

import exception.HeightLimitException;

/**
 * 模型：计算BMI的 业务逻辑
 * 
 * @author soft01
 * 
 */
public class BMIService {
	public String bmi(double height, double weight, String gender) throws Exception{

		// 对传过来的参数要进行验证
		if(height>2.5||height<0){
			//抛应用性异常
			throw new HeightLimitException();
		}
		double bmi = weight/height/height;
		String rs = "";
		if(gender.equals("m")){
			if(0<bmi&&bmi<20){
				rs="过轻";
			}else if(bmi>=20&&bmi<25){
				rs="适中";
			}else if(bmi>=25&&bmi<30){
				rs="过重";
			}else if(bmi>=30&&bmi<35){
				rs="肥胖";
			}else if(bmi>=35&&bmi<40){
				rs="太有份量啦！";
			}
		}else{
			if(bmi<20){
				rs="过轻";
			}else if(bmi>=20&&bmi<25){
				rs="适中";
			}else if(bmi>=25&&bmi<30){
				rs="过重";
			}else if(bmi>=30&&bmi<35){
				rs="肥胖";
			}else if(bmi>=35&&bmi<40){
				rs="太有份量啦！";
			}
		}
		return rs;
	}
}
