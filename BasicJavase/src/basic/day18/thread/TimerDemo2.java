package basic.day18.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 定时器的使用java.util.Timer
 *  void 	schedule(TimerTask task, Date time)
	  		安排在指定的时间执行指定的任务。
 	void 	schedule(TimerTask task, Date firstTime, long period)
          安排指定的任务在指定的时间开始进行重复的固定延迟执行。
 */
public class TimerDemo2 {
	public static void main(String[] args) {
		final Timer timer = new Timer();
		Date date = new Date();
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR_OF_DAY, 7);//早上七点
		cal.set(Calendar.SECOND, 0);
		date = cal.getTime();
		//不建议使用如下：不是TMT格式
//		long utc = cal.getTimeInMillis();//返回的是UTC标准
//		Date d = new Date(utc);
//		System.out.println(d);
		
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
		
		
		//10秒的倒计时
		final long end = System.currentTimeMillis()+10*1000;//当前毫秒数加十秒
		//三个参数，延持多长时间执行。下表，从现在开始，每1秒，就..
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				long now = System.currentTimeMillis();//run()方法运行时的当前时间 
				long show = end-now;//剩余时间毫秒数
				long s = show/1000;//转换成秒
				System.out.println(s);//显示剩余时间
			}}, 0,1000);
		
		//在结束那一时刻执行
		timer.schedule(new TimerTask(){
			public void run(){
				System.out.println("计时结束！");
				timer.cancel();//取消所有计时。
			}
		}, new Date(end));//
		
	}
}
