package basic.day18.IO.mldn_io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**实例操作二：实现日期格式的数据输入
 *	在Scanner类中没有提供专门的日期格式输入操作，所以，如果想得到一个日期类型的
 *数据，则必须自己编写正则验证，并手工转换。 
 */
public class ScannerDemo03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入日期(yyyy-MM-dd):");
		String str = null;
		Date date = null;
		if(scan.hasNext("^\\d{4}-\\d{2}-\\d{2}$")){//判断输入格式是否是日期
			str = scan.next("^\\d{4}-\\d{2}-\\d{2}$");//接收日期格式的字符串
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("输入的日期格式错误！");
		}
		System.out.println(date);
	}
}
