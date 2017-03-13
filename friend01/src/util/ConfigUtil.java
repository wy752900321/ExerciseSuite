package util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	private static Properties props = new Properties();
	static{
		InputStream ips = 
			ConfigUtil.class.getClassLoader().getResourceAsStream("daoconfig.properties");
		try {
			props.load(ips);
		} catch (IOException e) {
			// FIXME Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getProperty(String key){
		return props.getProperty(key);
	}
}
