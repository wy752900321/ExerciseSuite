package cn.itcast.i18n;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class Demo2 {

	/**
	 * @param args
	 */
	@Test
	public void test1(){

		Date date = new Date();
		
		DateFormat df = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.CHINA);
		String result = df.format(date);
		System.out.println(result);
		
		df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.LONG, Locale.CHINA);
		result = df.format(date);
		System.out.println(result);
		
	}
	
	@Test
	public void test2() throws ParseException{
		String s = "2011年8月10日 星期三 下午02时12分33秒";
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.LONG, Locale.CHINA);
		Date  d = df.parse(s);
		System.out.println(d);
		
	}
	
	@Test
	public void test3() throws ParseException{
		
		double price = 1000;
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.GERMAN);
		String result = nf.format(price);
		System.out.println(result);
		
		String s = "¤ 1.000,00";
		double d = nf.parse(s).doubleValue();
		System.out.println(d);
	}

	
	@Test
	public void test4() throws ParseException{
		NumberFormat nf = NumberFormat.getPercentInstance();
		System.out.println(nf.format(0.5));
	}
	
	@Test
	public void test5(){
		String pattern = "At {0, time, short} on {0, date}, a destroyed {1} houses and caused {2, number, currency} of damage.";
		MessageFormat mf = new MessageFormat(pattern,Locale.CHINA);
		Object params[] = {new Date(),99,1000000};
		String result = mf.format(params);
		System.out.println(result);
	}
	
	@Test
	public void test6(){
		
		ResourceBundle rb = ResourceBundle.getBundle("cn.itcast.resource.MyResource",Locale.ENGLISH);
		String message = rb.getString("message");
		
		MessageFormat format = new MessageFormat(message,Locale.ENGLISH);
		Object params[] = {new Date(),99,1000000};
		System.out.println(format.format(params));
	}
}
