package util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ¶Áconfig.propertiesÎÄ¼þ
 */
public class ConfigUtil {
	private static Properties props = new Properties();
	static {
		//
		ClassLoader loader = ConfigUtil.class.getClassLoader();
		InputStream ips = loader.getResourceAsStream("util" + File.separator
				+ "config.properties");
		try {
			props.load(ips);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return props.getProperty(key);
	}

	public static void main(String[] args) {
		System.out.println(getProperty("ComputerDAO"));
	}
}
