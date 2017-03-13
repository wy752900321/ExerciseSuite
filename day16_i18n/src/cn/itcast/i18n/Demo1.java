package cn.itcast.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("cn.itcast.resource.MyResource",Locale.CHINA);
		String username = rb.getString("username");
		String password = rb.getString("password");
		
		System.out.println(username);
		System.out.println(password);
		

	}

}
