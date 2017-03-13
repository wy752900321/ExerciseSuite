package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config extends Properties{
	private static final long serialVersionUID = 1L;
	//私有的静态属性
	private static Config config = new Config();
	//私有的构造方法
	private Config(){
		try {
			this.load(new FileInputStream("proper/mysqldb.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	//公有的静态方法
	public static Config getInstrance(){
		return config;
	}
/*	
 *		此处为单例模式的懒汉式模式，上面所使用的代码为饿汉式
 *		上面的代码同样可以使用此处的代码代替
 *
 * public static Config getInstrance(){
		if(config!=null){
			config = new Config();
			return config;
		}else{
			newInstrance();
			return config;
		}
	}
	synchronized public static void newInstrance(){
		if(config==null){
			config = new Config();
		}
	}
*/	public static String getString(String key){
		return Config.getInstrance().getProperty(key);
	}
		/*public static void main(String[] args) {
			System.out.println(Config.getString("java"));
		}*/
}
