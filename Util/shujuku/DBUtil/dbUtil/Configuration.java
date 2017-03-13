package dbUtil;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Configuration {
	private String driver;
	private String url;
	private String username;
	private String password;
	private int initialSize;
	private int maxActive;
	private int maxIdle;
	private int minIdle;
	
	//构造器
	public Configuration(){}
	public Configuration(String driver, String url, String username,
			String password, int initialSize, int maxActive, int maxIdle,
			int minIdle) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
		this.initialSize = initialSize;
		this.maxActive = maxActive;
		this.maxIdle = maxIdle;
		this.minIdle = minIdle;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getInitialSize() {
		return initialSize;
	}
	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}
	public int getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}
	public int getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}
	public int getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
	//创建Configuration对象
	public static Configuration config(String path){
		InputStream in=Configuration.class.
						getResourceAsStream(path);
		Configuration config=null;
		try {
			config = load(in);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return  config;
	}
	//读取xml配置文件
	private static Configuration load(InputStream in) throws DocumentException {
		SAXReader reader= new SAXReader();
		Document doc=reader.read(in);
		Element jdbc=doc.getRootElement();
		String driver=jdbc.elementText("driver");
		String url=jdbc.elementText("url");
		String username=jdbc.elementText("username");
		String password=jdbc.elementText("password");
		Element dbcp=jdbc.element("dbcp");
		int initialSize=Integer.parseInt(dbcp.elementText("initialSize"));
		int maxActive=Integer.parseInt(dbcp.elementText("maxActive"));
		int maxIdle=Integer.parseInt(dbcp.elementText("maxIdle"));
		int minIdle=Integer.parseInt(dbcp.elementText("minIdle"));
		Configuration config=new Configuration(
		driver,url,username,
		password,initialSize, maxActive,
		maxIdle,minIdle);
		return config;
	}
	//重写toString()方法
	public String toString(){
		 return driver+","+url+","+username
		 +","+password+","+initialSize+","+
		 maxActive+","+maxIdle+","+minIdle;
	}
}







