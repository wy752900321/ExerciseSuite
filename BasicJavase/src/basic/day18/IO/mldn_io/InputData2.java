package basic.day18.IO.mldn_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 对输入数据类进一步扩充 扩充InputData 输入各种类型的数据
 * 此程序实现整数、小数、字符串、日期类型数据的输入。
 */

public class InputData2 {
	private BufferedReader buf = null;

	public InputData2() {
		this.buf = new BufferedReader(new InputStreamReader(System.in));// 在类的构造方法中实例化InputStreamReader对象
	}

	public String getString(String info) { // 从此方法中得到字符串的信息
		String temp = null;
		System.out.println(info); // 打印提示信息
		try {
			temp = this.buf.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public int getInt(String info,String err){	//得到一个整数的输入数据
		int temp = 0;
		String str = null;
		boolean flag = true;
		while(flag){
			str = this.getString(info);
			if(str.matches("^\\d+$")){//判断输入的是否是数字
				temp = Integer.parseInt(str);//将字符串变为数字
				flag = false;			//更改标志位之后，将退出循环
			}else{
				System.out.println(err);	//出错时，则打印传递来的出错信息
			}
		}
		return temp;
	}
	
	public float getFloat(String info,String err){//得到一个小数的输入数据
		float temp = 0;
		String str = null;
		boolean flag = true;
		while(flag){
			str = this.getString(info);
			if(str.matches("^\\d+.?\\d+$")){//判断是否是小数
				temp = Float.parseFloat(str);
				flag = false;				//更改标志位之后，将退出循环
			}else{
				System.out.println(err);
			}
		}
		return temp;
	}
	
	public Date getDate(String info,String err){	//得到一个日期数据
		Date d = null;
		String str = null;
		boolean flag = true;			//定理一个循环处理标志
		while(flag){
			str = this.getString(info);
			if(str.matches("^\\d{4}-\\d{2}-\\d{2}$")){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try{
					d = sdf.parse(str);
				}catch(ParseException e){
					e.printStackTrace();
				}
				flag = false;
			}else{
				System.out.println(err);
			}
		}
		return d;
	}
}
