package basic.day18.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 定时器的使用
 */
public class TimerDemo {
	public static void main(String[] args) {
		Timer timer = new Timer();
		Date date = new Date();
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR_OF_DAY, 7);//早上七点
		cal.set(Calendar.SECOND, 0);
		date = cal.getTime();
		//不建议使用如下：不是TMT格式
		long utc = cal.getTimeInMillis();//返回的是UTC标准
		Date d = new Date(utc);
		System.out.println(d);
		
		//没有延持
//		timer.schedule(new TimerTask(){
//			public void run(){
//				System.out.println("起床啦！");
//			}
//		}, date);
		//可延持
		timer.schedule(new TimerTask(){
			public void run(){
				System.out.println("起床啦！");
			}
		}, date,1000L*60*60*24);//延持时间1000L*60*60*24
		
	}
}
