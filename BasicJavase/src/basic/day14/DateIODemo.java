package basic.day14;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class DateIODemo {
	public static void main(String[] args)throws ParseException {
		Date date = new Date();
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = fmt.format(date);
		System.out.println(str);//2012-03-15 16:21:58
		
		str = "2012-12-31";
		fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date d = fmt.parse(str);
		System.out.println(d);//Mon Dec 31 00:00:00 CST 2012
		System.out.println(fmt.format(d));//2012-12-31
		
		str = "19890208";//根据身份证号计算生日(Date)
		//"yyyy-MM-dd"
		fmt = new SimpleDateFormat("yyyyMMdd");
		Date birthday = fmt.parse(str);
		System.out.println(birthday.getTime());
		//parse方法的原理：
		long n = (1989-1970)*1000L*60*60*24*365+//年
		2*1000L*60*60*24*30+//月
		8*1000L*60*60*24;//日
		System.out.println(n);
	}
}
