package basic.day14;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateCastDemo {
public static void main(String[] args) {
	long gmt = 0;//1970 1 1 00:00:00,000
	Date date = new Date();//默认是当前时间
	//date.setTime(long time)设置此 Date 对象，以表示 1970 年 1 月 1 日 00:00:00 GMT 以后 time 毫秒的时间点。 
	date.setTime(gmt);
	//date.getYear():返回一个值，此值是从包含或开始于此 Date 对象表示的瞬间的年份减去 1900 的结果（用本地时区进行解释）
	//返回值为：日期表示的年份减去 1900。
	System.out.println(date.getYear());//70
	System.out.println(date);//Thu Jan 01 08:00:00 CST 1970
	Calendar cal = new GregorianCalendar();
	//setTime(Date date):使用给定的 Date 设置此 Calendar 的时间。
	cal.setTime(date);//date转为cal
	//get(int field):参数field是给定的日历字段。返回椒给定字段的值
	//Calendar:YEAR = 1970、MONTH = JANUARY、DAY_OF_MONTH = 1，等等。 
	System.out.println(cal.get(Calendar.YEAR));//1970
	
	//1969 12 31 00:00:00,000
	//add(int field,int amount)根据日历的规则，为给定的日历字段添加或减去指定的时间量
	cal.add(Calendar.DAY_OF_YEAR, -1);//当前时间减少一天
	//时间的计算，本质上是long类型的历法技术
	//减少一天就是：0-1000L*60*60*24
	System.out.println(cal.get(Calendar.YEAR));//1969
	Date d = cal.getTime();
	System.out.println(d.getYear());//69
	long l = d.getTime();
	System.out.println(l);
	System.out.println(1000L*60*60*24);
	}
}
