package basic.day14;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateCalDemo {
	public static void main(String[] args) {
		// 时间计算的原理：
		long now = System.currentTimeMillis();//  当前时间
		long l = now + 1000L * 60 * 60 * 24;// 明天
		System.out.println(l);
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(fmt.format(new Date(l)));
		//得到更长的时间
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.MONTH, 5);//增加5个月的毫秒数
		cal.add(Calendar.YEAR, 5);//增加5年的毫秒数
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//把日期改为本周的周一
		System.out.println(fmt.format(cal.getTime()));
	}
}
