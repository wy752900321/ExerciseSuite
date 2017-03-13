package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class Config extends Properties {
	private static final long serialVersionUID = 1L;
		//私有的静态属性
		private static Config config;
		//私有的构造方法
		private Config(){
			InputStream is = this.getClass().getResourceAsStream("/Properties");
			try {
				this.load(is);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		//公有的静态方法
		public static Config getInstrance(){
			if(config!=null){
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
		public static String getString(String key){
			return Config.getInstrance().getProperty(key);
		}
		public static void main(String[] args) {
				
				System.out.println(Config.getString("java"));
		}
}
