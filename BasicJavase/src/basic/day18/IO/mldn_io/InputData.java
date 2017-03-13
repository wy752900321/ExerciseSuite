package basic.day18.IO.mldn_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**(2) 对类进行合理的划分
 * 	对于输入数据，最常见的可能 是整数，小数，日期，字符串，所以此时最好将其设计
 *  一个专门的输入数据类，完成输入数据的功能。
 *  范例如下：完成一个专门处理输入数据的类，只能得到整数和字符串。
 *  以后只要是想得到输入数据，则直接可以从此类中得到。
 */
public class InputData {
	private BufferedReader buf = null;
	public InputData(){				//在类的构造方法中实例化BufferedReader类
		this.buf=new BufferedReader(new InputStreamReader(System.in));
		
	}
	public String getString(String info){//从此方法中得到字符串的信息
		String temp = null;
		System.out.println(info);       //打印提示信息
		try{
			temp = this.buf.readLine();
		}catch(IOException e){
			e.printStackTrace();
		}
		return temp;
	}
	public int getInt(String info,String err){//得到一个整数的输入数据
		int temp = 0;
		String str = null;
		boolean flag = true;				//定义一个循环的处理标志
		while(flag){
			str = this.getString(info);
			if(str.matches("^\\d+$")){		//判断输入的是否是数字\d表示[0-9]，+表示出现1到n次
				temp = Integer.parseInt(str);//将字符口变为数字
				flag = false;				//更改标志位之后，将退出循环
			}else{
				System.out.println(err);   //出现错误，则打印传递进的错误信息
			}
		}
		return temp;
	}
}
